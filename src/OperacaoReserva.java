public class OperacaoReserva implements Runnable{

    private Livro livro;

    public OperacaoReserva(Livro livro){
        this.livro = livro;
    }

    public synchronized void reservarLivro(){
        System.out.println("Iniciando reserva");
        if(!livro.getReservado()){
            livro.reservar();
            System.out.println("Reserva feita com sucesso! Aproveite a leiura, " + Thread.currentThread().getName());
        } else {
            System.out.println("O livro já foi reservado, tente novamente em outro momento " + Thread.currentThread().getName());
        }
    }

    @Override
    public void run(){
        reservarLivro();
    }
}
