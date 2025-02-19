package gerenciamentodebiblioteca;

import java.util.Scanner;
import java.util.ArrayList;
public class Biblioteca {
    //ATRIBUTOS
    private Livro livro;
    private ArrayList<Livro> listalivros;
    
    //ENCAPSULAMENTO
    public Livro getLivro(){
        return livro;
    }
    public void setLivro(Livro livro){
        this.livro = livro;
    }

    public ArrayList<Livro> getListalivros(){
        return listalivros;
    }
    public void setListalivros(ArrayList<Livro> listalivros){
        this.listalivros = listalivros;
    }
    
    //CONSTRUTOR
    public Biblioteca(){
       this.listalivros = new ArrayList();
    }
    
    //METODOS DE OPERAÇÕES
    public void CadastrarLivro(Livro livro){
        listalivros.add(livro);
        System.out.println();
    }
    
    
    public void BuscarLivro(){
        if (listalivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.println("Digite : [1] - Busca por Titulo / [2] - Busca por Autor ");
        System.out.print("Escolha uma opçao: ");
        int resp = teclado.nextInt();
        teclado.nextLine();
        
        //BUSCAS POR TITULO
        if (resp==1) {
            System.out.print("Titulo do livro: ");
            String tituloLivro = teclado.nextLine();
            boolean livroEncontrado = false;
            for (int i = 0; i < listalivros.size(); i++) {
                if (listalivros.get(i).getTitulo().equalsIgnoreCase(tituloLivro)) {
                    System.out.println();
                    System.out.println("LIVRO ENCONTRADO: ");
                    System.out.println("Titulo: " + listalivros.get(i).getTitulo());
                    System.out.println("Autor: " + listalivros.get(i).getAutor());
                    System.out.println("ISBN: " + listalivros.get(i).getISBN());
                    System.out.print("Estoque atual: " + listalivros.get(i).getQtdeEstoque());
                    livroEncontrado = true;
                    System.out.println();
                }
            }
            if (livroEncontrado==false) {
                System.out.println();
                System.out.println("Livro nao encontrado");
                System.out.println();
            }
            
        }
        
        //BUSCAS POR AUTOR
        if (resp==2) {
            System.out.print("Autor do livro: ");
            String autorLivro = teclado.nextLine();
            boolean livroEncontrado = false;
            System.out.println();
            System.out.println("LIVROS ENCONTRADOS: ");
            for (int i = 0; i < listalivros.size(); i++) {
                if (listalivros.get(i).getAutor().equalsIgnoreCase(autorLivro)) {
                    System.out.println();
                    System.out.println("LIVRO: ");
                    System.out.println("Titulo: " + listalivros.get(i).getTitulo());
                    System.out.println("Autor: " + listalivros.get(i).getAutor());
                    System.out.println("ISBN: " + listalivros.get(i).getISBN());
                    System.out.print("Estoque atual: " + listalivros.get(i).getQtdeEstoque());
                    livroEncontrado = true;
                    System.out.println();
                }
            }
               if (livroEncontrado==false) {
                   System.out.println();
                   System.out.println("Livro nao encontrado");
                   System.out.println();
            }
        }
    }
    
    public void ListarLivros(){
        System.out.println();
        System.out.println("LIVROS DA BIBLIOTECA: ");
        for (int i = 0; i < listalivros.size(); i++) {
            System.out.println();
            System.out.println("LIVRO #" + (i+1));
            System.out.println("Titulo: " + listalivros.get(i).getTitulo());
            System.out.println("Autor: " + listalivros.get(i).getAutor());
            System.out.println("ISBN: " + listalivros.get(i).getISBN());
            System.out.print("Estoque atual: " + listalivros.get(i).getQtdeEstoque());
            System.out.println();
        }
    }

    public void ComprarLivros(int quantidade){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o titulo do livro que deseja comprar: ");
        String tituloLivro = teclado.nextLine();
        boolean livroEncontrado = false;
        for (int i = 0; i < listalivros.size(); i++) {
             if (listalivros.get(i).getTitulo().equalsIgnoreCase(tituloLivro) && listalivros.get(i).getQtdeEstoque() < quantidade) {
                     livroEncontrado = true;
                     System.out.println();
                     System.out.println("Estoque insuficiente");
                     System.out.println();
                     return;
                 }
             if (listalivros.get(i).getTitulo().equalsIgnoreCase(tituloLivro) && listalivros.get(i).getQtdeEstoque()>0 && listalivros.get(i).getQtdeEstoque() > quantidade) {
                 listalivros.get(i).ReduzirEstoque(quantidade);
                 System.out.println();
                 System.out.println("Livro(s) comprado(s) com sucesso!");
                 System.out.println();
                 livroEncontrado = true;
                 System.out.println();
            }
        }
        if (livroEncontrado==false) {
            System.out.println();
            System.out.println("Livro nao encontrado");
            System.out.println();
        }
    }

    public void RealizarDevoluçao(int quantidade){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o titulo do livro que deseja devolver: ");
        String tituloLivro = teclado.nextLine();
        boolean livroEncontrado = false;
        for (int i = 0; i < listalivros.size(); i++) {
             if (listalivros.get(i).getTitulo().equalsIgnoreCase(tituloLivro)) {
                listalivros.get(i).AumentarEstoque(quantidade);
                 System.out.println();
                System.out.println("Livro(s) devolvido(s) com sucesso!");
                System.out.println();
                livroEncontrado = true;
            }
        }
        if (livroEncontrado==false) {
            System.out.println();
            System.out.println("Livro nao encontrado");
            System.out.println();
        }
        
    }
    
    public void RemoverLivro(){
        Scanner teclado = new Scanner(System.in);
        
        if (listalivros.isEmpty()) {
            System.out.println();
            System.out.println("Nenhum livro cadastrado");
            System.out.println();
            return;
        }else{
            System.out.print("Informe o titulo do livro a ser removido: ");
            String tituloLivro = teclado.nextLine();
            boolean livroEncontrado = false;
            for (int i = 0; i < listalivros.size(); i++) {
            if (listalivros.get(i).getTitulo().equalsIgnoreCase(tituloLivro)) {
                listalivros.remove(i);
                System.out.println();
                System.out.println("Livro removido com sucesso!");
                System.out.println();
                livroEncontrado = true;
                
            }
        }
            if (livroEncontrado == false) {
               System.out.println();
               System.out.println("Livro nao encontrado");
               System.out.println();
               
        }
        }
        
        
        
        
    }
    
    
}
