package leitorlivro;
/**
 *
 * @author fauri
 */
public interface Publicacao {
    public abstract void abrir();
    public abstract void fechar();
    public abstract void folhear(int p);
    public abstract void avancarPag();
    public abstract void voltarPag();
    public abstract void marcarPag(int p);
    public abstract void pegarLivro(Pessoa p);
    public abstract void devolverLivro(int falta);
    public abstract void pagarDivida();
}
