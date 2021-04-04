import java.util.Scanner;

public class Main {

    public static class NumeroDeDias{
        private int anoInicial, anoFinal, mesInicial, mesFinal, diaInicial, diaFinal;
        private int ajuste = 0;
        private int ctdDia = 0;

        public NumeroDeDias(int anoInicial, int anoFinal, int mesInicial, int mesFinal, int diaInicial, int diaFinal){
            this.anoInicial = anoInicial;
            this.anoFinal = anoFinal;
            this.mesInicial = mesInicial;
            this.mesFinal = mesFinal;
            this.diaInicial = diaInicial;
            this.diaFinal = diaFinal;
            contaAno();
        }
        public void contaAno(){

            if(anoFinal == anoInicial && (anoInicial % 400 == 0 || (anoInicial % 4 == 0 && anoInicial % 100 != 0))){
                ajuste++;
            }else{//     2004              2009
                for(int i = anoInicial; i <= anoFinal; i++){
                    if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
                        ajuste++;
                    }
                }
            }
            ctdDia = (anoFinal - anoInicial) * 365 + ajuste;
            contaMes();
        }
        public void contaMes(){
            if(mesInicial > 2 && (anoInicial % 400 == 0 || (anoInicial % 4 == 0 && anoInicial % 100 != 0))){
                ctdDia--;
            }
            if(mesInicial < mesFinal){
                for(int i = mesInicial; i < mesFinal; i++){
                    if(i == 2){
                        ctdDia = ctdDia + 28;
                    }else if (i == 4 || i == 6 || i == 9 || i == 11){
                        ctdDia = ctdDia + 30;
                    }else{
                        ctdDia = ctdDia + 31;
                    }
                }
            }else if(mesInicial >= mesFinal){
                if(mesInicial >= mesFinal && mesFinal <= 2 && (anoFinal % 400 == 0 || (anoFinal % 4 == 0 && anoFinal % 100 != 0))){
                    ctdDia--;
                }
                for(int i = mesFinal; i < mesInicial; i++){
                    if (i == 4 || i == 6 || i == 9 || i == 11){
                        ctdDia = ctdDia - 30;
                    }else if(i == 2){
                        ctdDia = ctdDia - 28;
                    }else{
                        ctdDia = ctdDia - 31;
                    }
                }
            }
            contaDia();
        }

        public void contaDia(){
            ctdDia = ctdDia + (diaFinal - diaInicial);
            diferençaDeDias();
        }

        public int diferençaDeDias(){
            return ctdDia;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner dado = new Scanner(System.in);

        int n = dado.nextInt();
        dado.nextLine();
        String[] dataInicial;
        String[] dataFinal;


        for(int i = 0; i < n; i++){
            dataInicial = dado.nextLine().split("-");
            dataFinal = dado.nextLine().split("-");

            NumeroDeDias salve = new NumeroDeDias(Integer.valueOf(dataInicial[0]), Integer.valueOf(dataFinal[0]), Integer.valueOf(dataInicial[1]), Integer.valueOf(dataFinal[1]), Integer.valueOf(dataInicial[2]), Integer.valueOf(dataFinal[2]));
            System.out.println("Quantidade de dias: "+salve.diferençaDeDias());
        }
    }
}