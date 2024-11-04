package br.edu.unisep.gerenciador.view;

import javax.swing.*;
import java.util.ArrayList;

public class GerenciadorDeTarefas {

    private ArrayList<String> tarefas;

    public GerenciadorDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            String tarefaConcluida = tarefas.get(indice) + " (Concluída)";
            tarefas.set(indice, tarefaConcluida);
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida.");
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida.");
        }
    }

    public String exibirTarefas() {
        StringBuilder listaTarefas = new StringBuilder("Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            listaTarefas.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return listaTarefas.toString();
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        String menu = "Selecione uma opção:\n" +
                "1. Adicionar tarefa\n" +
                "2. Marcar tarefa como concluída\n" +
                "3. Remover tarefa\n" +
                "4. Exibir todas as tarefas\n" +
                "5. Sair";
        while (true) {
            String opcao = JOptionPane.showInputDialog(menu);
            switch (opcao) {
                case "1":
                    String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
                    gerenciador.adicionarTarefa(novaTarefa);
                    break;
                case "2":
                    String tarefasListadas = gerenciador.exibirTarefas();
                    String tarefaEscolhida = JOptionPane.showInputDialog(tarefasListadas + "Digite o número da tarefa a marcar como concluída:");
                    try {
                        int indiceConcluir = Integer.parseInt(tarefaEscolhida) - 1;
                        gerenciador.marcarTarefaConcluida(indiceConcluir);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
                    }
                    break;
                case "3":
                    tarefasListadas = gerenciador.exibirTarefas();
                    String tarefaRemover = JOptionPane.showInputDialog(tarefasListadas + "Digite o número da tarefa a remover:");
                    try {
                        int indiceRemover = Integer.parseInt(tarefaRemover) - 1;
                        gerenciador.removerTarefa(indiceRemover);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, gerenciador.exibirTarefas());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saindo do Gerenciador de Tarefas.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}
