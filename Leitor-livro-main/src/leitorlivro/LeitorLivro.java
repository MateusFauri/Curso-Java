package leitorlivro;
/**
 *
 * @author fauri
 */
public class LeitorLivro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("Mateus","m",22);
        p[1] = new Pessoa("Crislaine","f",23);
        l[0] = new Livro("Guia Definitivo do Mochileiro Das Galaxias","Douglas Adams",670);
        l[1] = new Livro("1984","George Orwell",346);
        l[2] = new Livro("O mundo assombrado pelos demônios","Carl Sagan", 512);
        
        l[1].pegarLivro(p[1]);
        l[1].devolverLivro(-2);
        l[1].pagarDivida();
        l[1].devolverLivro(0);
        
        /*
        //o programa nao ira deixar l[1] pegar esse livro, pois ele ja possui um leitor!
        l[1].pegarLivro(p[0]);
        l[2].pegarLivro(p[1]);
      
        // pegando o livro e devolvendo para ver se funciona
        l[0].pegarLivro(p[0]);
        l[0].detalhes();
        l[0].devolverLivro();

        //funcionalidades funcionando normalmente
        l[0].pegarLivro(p[1]);
        l[0].marcarPag(154);
        l[0].marcarPag(200);
        l[0].abrir();
        l[0].folhear(100);
        l[0].detalhes();

        */
    }
    
}
