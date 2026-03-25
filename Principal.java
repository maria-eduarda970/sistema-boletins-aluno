import java.util.Scanner;

class Aluno {
    String matricula;
    String nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
    }
}

class Boletim {
    Aluno aluno;
    double nota1, nota2, nota3;

    public Boletim(Aluno aluno, double nota1, double nota2, double nota3) {
        this.aluno = aluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    String mostrarSituacao() {
        double media = calcularMedia();
        if (media >= 7) return "Aprovado";
        else if (media >= 5) return "Recuperação";
        else return "Reprovado";
    }

    void exibirBoletim() {
        System.out.println("\n--- Boletim do Aluno ---");
        aluno.exibirDados();
        System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.printf("Média: %.2f%n", calcularMedia());
        System.out.println("Situação: " + mostrarSituacao());
    }
}

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Boletim[] boletins = new Boletim[3];
        int aprovados = 0, recuperacao = 0, reprovados = 0;
        double melhorMedia = -1;
        String melhorAluno = "";

        for (int i = 0; i < 3; i++) {
            System.out.println("\nCadastro do aluno " + (i + 1));
            System.out.print("Matrícula: ");
            String matricula = sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Nota 1: ");
            double n1 = sc.nextDouble();
            System.out.print("Nota 2: ");
            double n2 = sc.nextDouble();
            System.out.print("Nota 3: ");
            double n3 = sc.nextDouble();
            sc.nextLine(); // Limpa o buffer

            Aluno aluno = new Aluno(matricula, nome);
            Boletim boletim = new Boletim(aluno, n1, n2, n3);
            boletins[i] = boletim;

            double media = boletim.calcularMedia();
            String situacao = boletim.mostrarSituacao();

            if (media > melhorMedia) {
                melhorMedia = media;
                melhorAluno = nome;
            }

            if (situacao.equals("Aprovado")) aprovados++;
            else if (situacao.equals("Recuperação")) recuperacao++;
            else reprovados++;
        }

        System.out.println("\n=== Boletins dos Alunos ===");
        for (Boletim b : boletins) {
            b.exibirBoletim();
        }

        System.out.println("\n=== Relatório Final ===");
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
        System.out.printf("Melhor média: %.2f - Aluno: %s%n", melhorMedia, melhorAluno);

        sc.close();
    }
}





