package gerenciamentodebiblioteca;


import java.util.Scanner;
import java.util.ArrayList;
public class GerenciamentoDeBiblioteca {

   
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        int resposta = 0;
        
        do { 
            //MENU DE OPERAÇÕES
            System.out.println();
            System.out.println("MENU");
            System.out.println("[1] - Cadastrar livro");
            System.out.println("[2] - Buscar livro");
            System.out.println("[3] - Listar todos os livros");
            System.out.println("[4] - Comprar livro");
            System.out.println("[5] - Realizar devoluçao");
            System.out.println("[6] - Remover livro");
            System.out.println("[7] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = teclado.nextInt();
            teclado.nextLine();
            
            //CADASTRAMENTO DE LIVROS
            if (resposta==1) {
                System.out.println();
                System.out.println("CADASTRAMENTO");
                System.out.println("Informe: ");
                System.out.print("Titulo do livro: ");
                String titulo = teclado.nextLine();
                System.out.print("Autor do livro: ");
                String autor = teclado.nextLine();
                System.out.print("ISBN do livro: ");
                String ISBN = teclado.next();
                if (ISBN.length() < 17 || ISBN.length() > 17) {
                    System.out.println();
                    System.out.println("O ISBN foi informado incorretamente");
                    System.out.println("Lembre-se de utilizar os hífens (-)");
                    return;
                }
                System.out.print("Estoque inicial a venda: ");
                int estoqueInicial = teclado.nextInt();
                Livro livro = new Livro(titulo,autor,ISBN,estoqueInicial);
                biblioteca.CadastrarLivro(livro);
                System.out.println();
                System.out.println("Livro cadastrado com sucesso!");
            }
            
            //BUSCA POR LIVROS
            if (resposta==2) {
                System.out.println();
                biblioteca.BuscarLivro();
                
            }
            
            //LISTAR LIVROS
            if (resposta==3) {
                biblioteca.ListarLivros();
            }
            
            //COMPRAR LIVROS
            if (resposta==4) {
                System.out.println();
                System.out.println("Para comprar um livro,favor informar a quantidade a ser comprada:");
                System.out.println("OBS : Caso queira comprar livros diferentes,favor realizar a compra de cada um separadamente");
                System.out.print("Quantidade : ");
                int quantidade = teclado.nextInt();
                biblioteca.ComprarLivros(quantidade);
            }
            
            //DEVOLUÇÃO DE LIVROS
            if (resposta==5) {
                System.out.println();
                System.out.println("Ao fazer devoluçao,favor informar a quantidade a ser devolvida:");
                System.out.println("OBS : Caso queira devolver livros diferentes,favor realizar a devoluçao de cada um separadamente");
                System.out.print("Quantidade : ");
                int quantidade = teclado.nextInt();
                biblioteca.RealizarDevoluçao(quantidade);
            }
            
            //REMOVER LIVROS
            if (resposta==6) {
                System.out.println("");
                biblioteca.RemoverLivro();
            }
            
            } while (resposta!=7);
    }
    
}
