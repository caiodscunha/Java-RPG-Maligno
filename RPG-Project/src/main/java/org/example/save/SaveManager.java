package org.example.save;

import org.example.models.personagens.players.player.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private static final String SAVE_DIRECTORY = "src/data/saves/";

    public static List<Save> listAllSaves(){
        List<Save> saves = new ArrayList<>();
        File dir = new File(SAVE_DIRECTORY);

        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Diretório de saves não encontrado: " + SAVE_DIRECTORY);
            return saves;
        }

        File[] saveFiles = dir.listFiles((d, name) -> new File(d, name).isFile());

        if (saveFiles == null) {
            return saves;
        }

        for (File file : saveFiles) {
            // Tenta carregar cada arquivo
            Save save = carregar(file.getName());
            if (save != null) {
                saves.add(save);
            }
        }
        return saves;
    }

    public static boolean salvar(String fileName, Save data) {
        File file = new File(SAVE_DIRECTORY + fileName);

        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Diretório de saves criado: " + parentDir.getAbsolutePath());
            } else {
                System.err.println("Falha ao criar o diretório de saves.");
                return false;
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(data);
            System.out.println("Jogo salvo com sucesso!");
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
            return false;
        }
    }

    public static Save carregar(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_DIRECTORY + fileName))) {
            return (Save) ois.readObject();
        } catch (Exception e) {
            System.err.println("Erro ao carregar jogo: " + e.getMessage());
            return null;
        }
    }
}
