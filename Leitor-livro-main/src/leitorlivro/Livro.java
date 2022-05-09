package leitorlivro;
/**
 *
 * @author fauri
 */
public class Livro implements Publicacao {
    //Atributos
    private Pessoa leitor;
    private String titulo,autor;
    private boolean aberto;
    private int totPaginas,pagAtual,tempo;
    private int[] marcar = new int[10];
    private float divida;

    
    
    //Metodos
    private float tempoDevolucao(){
        return this.tempo = this.totPaginas / 50 ;
        /*   Como foi calculado o processo de paginas:
        *   50 - 1dia
        *   paginas - xdias
        *   xdias = paginas/50
        */
    }
    
    private void calDivida(int falta){ 
        //precisei usar a variavel falta
        // pois não consigo calcular o tempo de forma automatica ainda!
        if(falta < 0){
            this.divida = (float) (0.5 * Math.abs(falta));
        }else{
            System.out.println("Não há dividas.");
        }
        
    }
    
    public void detalhes(){
        if(this.leitor != null){
            System.out.println("------------------------");
            System.out.println("Detalhes do leitor(a):");
            System.out.println("Nome: "+ this.leitor.getNome());
            System.out.println("Idade: "+this.leitor.getIdade());
            System.out.println("Sexo: "+this.leitor.getSexo());
        }else{
            System.out.println("#################################");
            System.out.println("Não tem ninguem lendo este livro.");
            System.out.println("#################################");
        }

        System.out.println("-------------------------------");
        System.out.println("Detalhes do livro:");
        System.out.println("O livro que escolheu é: " + this.getTitulo());
        System.out.println("De autoria: " + this.getAutor());
        System.out.println("O livro tem um total de " + this.getTotPaginas() + " paginas.");
        System.out.println("Paginas marcadas:");
        for(int i=0; i<this.marcar.length; i++){
            if(this.marcar[0]== 0){
                System.out.println("não ha paginas marcadas");
                break;
            }else if(this.marcar[i] == 0){
                break;
            }else{
                System.out.print(this.marcar[i] + " - ");
            }
        }
        System.out.println(" ");
        if(this.isAberto()){
            System.out.println("O livro está aberto na pagina " + this.getPagAtual());
        }else{
            System.out.println("O livro está fechado.");
        }
        
    }
    
    
    //Metodos Especiais
    //Construtor
    public Livro(String titulo, String autor, int totPaginas) {  
        this.leitor = null;
        this.autor = autor;
        this.titulo = titulo;
        this.aberto = false;
        this.totPaginas = totPaginas;
        this.pagAtual = 1;
        this.divida = 0;
    }

    //Getters and Setters
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
    
    
    //Metodos Encapsulados
    
    @Override
    public void abrir() {
        if(this.isAberto()){
            System.out.println("O livro ja esta aberto!");
        }else{
            System.out.println("Abrindo o livro....");
            this.aberto = true;
        }
    }

    @Override
    public void fechar() {
        if(!this.isAberto()){
            System.out.println("O livro ja esta fechado!");
        }else{
            System.out.println("Fechando o livro....");
            this.aberto = false;
        }
    }

    @Override
    public void folhear(int p) {
        if(p > this.totPaginas){    
            System.out.println("O livro não tem mais esse numero de paginas! Indo ate a pagina final");
            this.pagAtual = this.totPaginas ;
        }else{
            this.pagAtual = p;
        }
    }

    @Override
    public void avancarPag() {
        if(this.pagAtual == this.totPaginas ){
            System.out.println("Você ja esta na pagina final!");
        }else{
            this.pagAtual++;
            System.out.println("Avançando uma pagina...'");
        }
    }

    @Override
    public void voltarPag() {
        if(this.pagAtual == 1){
            System.out.println("Você ja esta na pagina Inicial!");
        }else{
            this.pagAtual--;
            System.out.println("Voltando uma pagina...");
        }
    }

    @Override
    public void marcarPag(int p) {
        for(int i=0;i <= this.marcar.length; i++){  //percorrendo o vetor para marcar a pagina
            if(this.marcar[i] == 0){ //quando ele achar um lugar com 0 (livro começa com a pagina 1) ele marca naquela posição
                this.marcar[i] = p; 
                System.out.println("Pagina " + this.marcar[i]+ " marcada.");
                break;
            }
        }
    }

    @Override
    public void pegarLivro(Pessoa p) {
        if(this.leitor != null){
            System.out.println("Você não pode pegar esse livro, pois alguem ja pegou!");
        }else{
            this.leitor = p;
            this.tempo = Math.round(this.tempoDevolucao());
            System.out.println("Voce tem " + this.tempo + " dias para devolver o livro.");
        }
    }

    @Override
    public void devolverLivro(int falta) {
        this.calDivida(falta);
        if(this.leitor != null && (this.tempo >= 0  && this.divida == 0)){
           this.leitor = null;
            System.out.println("Livro devolvido!");
        }else if(this.leitor != null && this.divida != 0){
            System.out.println("Page a divida antes de devolver!");
            System.out.println("Você possui " + this.divida + " de divida");
        }else{
            System.out.println("Esse livro não esta em posse de ninguem!");
        }
        
    }

    @Override
    public void pagarDivida() {
        this.divida = 0;
        System.out.println("Divida paga! Ja pode devolver o livro");
    }

}
