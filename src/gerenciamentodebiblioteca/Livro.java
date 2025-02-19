package gerenciamentodebiblioteca;


public class Livro {
    //ATRIBUTOS
    private String titulo;
    private String autor;
    private String ISBN;
    private int qtdeEstoque;
    
    //ENCAPSULAMENTO
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    
    //METODOS DE OPERAÇÕES
    public void ReduzirEstoque(int quantidade){
        this.qtdeEstoque -= quantidade;
    }
    
    public void AumentarEstoque(int quantidade){
        this.qtdeEstoque += quantidade;
    }
    
    
    //CONSTRUTOR
    public Livro(String titulo, String autor, String ISBN, int qtdeEstoque){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.qtdeEstoque = qtdeEstoque;
    }
    
    
    
}
