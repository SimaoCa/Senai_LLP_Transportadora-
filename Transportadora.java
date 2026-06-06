import java.util.Scanner;
interface Transporte {
    double calcularFrete(double peso, double altura, double largura, double distancia);
}

abstract class Veiculo implements Transporte {
    private int anoFabricacao;
    private String marca;
    private String modelo;
    private String propulsao;

    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPropulsao() { return propulsao; }
    public void setPropulsao(String propulsao) { this.propulsao = propulsao; }
}
class VeiculoTerrestre extends Veiculo {
    private int qtdeRodas;
    private int qtdePortas;
    private String placa;
    private String chassi;

    public int getQtdeRodas() { return qtdeRodas; }
    public void setQtdeRodas(int qtdeRodas) { this.qtdeRodas = qtdeRodas; }

    public int getQtdePortas() { return qtdePortas; }
    public void setQtdePortas(int qtdePortas) { this.qtdePortas = qtdePortas; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getChassi() { return chassi; }
    public void setChassi(String chassi) { this.chassi = chassi; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return 0;
    }
}

class VeiculoAereo extends Veiculo {
    private String rab;
    private int qtdeMotores;

    public String getRab() { return rab; }
    public void setRab(String rab) { this.rab = rab; }

    public int getQtdeMotores() { return qtdeMotores; }
    public void setQtdeMotores(int qtdeMotores) { this.qtdeMotores = qtdeMotores; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return 0;
    }
}

class VeiculoFluvial extends Veiculo {
    private String registroMarinha;
    private double boca;
    private double caladoAereo;

    public String getRegistroMarinha() { return registroMarinha; }
    public void setRegistroMarinha(String registroMarinha) { this.registroMarinha = registroMarinha; }

    public double getBoca() { return boca; }
    public void setBoca(double boca) { this.boca = boca; }

    public double getCaladoAereo() { return caladoAereo; }
    public void setCaladoAereo(double caladoAereo) { this.caladoAereo = caladoAereo; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return 0;
    }
}

class Caminhao extends VeiculoTerrestre {
    private int qtdeEixos;
    private double capacidade;
    private String carroceria;

    private static final double PRECO_DIESEL = 6.99;

    public int getQtdeEixos() { return qtdeEixos; }
    public void setQtdeEixos(int qtdeEixos) { this.qtdeEixos = qtdeEixos; }

    public double getCapacidade() { return capacidade; }
    public void setCapacidade(double capacidade) { this.capacidade = capacidade; }

    public String getCarroceria() { return carroceria; }
    public void setCarroceria(String carroceria) { this.carroceria = carroceria; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        // (peso + (altura * largura)) * (distância * preço do diesel)
        return (peso + (altura * largura)) * (distancia * PRECO_DIESEL);
    }
}

class Aviao extends VeiculoAereo {
    private double capacidadeCarga;
    private double mtow;

    private static final double PRECO_QUEROSENE = 9.99;

    public double getCapacidadeCarga() { return capacidadeCarga; }
    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }

    public double getMtow() { return mtow; }
    public void setMtow(double mtow) { this.mtow = mtow; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        // ((peso * peso) * (altura * largura)) * (distância * preço do querosene)
        return ((peso * peso) * (altura * largura)) * (distancia * PRECO_QUEROSENE);
    }
}

class PortaContainer extends VeiculoFluvial {
    private double capacidadeTeu;
    private String categoria;

    public double getCapacidadeTeu() { return capacidadeTeu; }
    public void setCapacidadeTeu(double capacidadeTeu) { this.capacidadeTeu = capacidadeTeu; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        // (peso + (altura * largura) * distancia)
        return peso + (altura * largura) * distancia;
    }
}

public class Transportadora {

    // Método que recebe a interface Transporte e retorna o frete
    public static double calcularFrete(Transporte veiculo, double peso, double altura, double largura, double distancia) {
        return veiculo.calcularFrete(peso, altura, largura, distancia);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        TRANSPORTADORA - FRETE        ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        System.out.print("Informe o peso da encomenda (kg): ");
        double peso = sc.nextDouble();

        System.out.print("Informe a altura da encomenda (m): ");
        double altura = sc.nextDouble();

        System.out.print("Informe a largura da encomenda (m): ");
        double largura = sc.nextDouble();

        System.out.print("Informe a distância do frete (km): ");
        double distancia = sc.nextDouble();

        Caminhao caminhao       = new Caminhao();
        Aviao aviao             = new Aviao();
        PortaContainer navio    = new PortaContainer();

        double freteCaminhao      = calcularFrete(caminhao,  peso, altura, largura, distancia);
        double freteAviao         = calcularFrete(aviao,     peso, altura, largura, distancia);
        double fretePortaContainer = calcularFrete(navio,    peso, altura, largura, distancia);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         TABELA DE FRETES             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  🚛 Caminhão:       R$ %12.2f  ║%n", freteCaminhao);
        System.out.printf( "║  ✈️  Avião:          R$ %12.2f  ║%n", freteAviao);
        System.out.printf( "║  🚢 Porta-Container: R$ %11.2f  ║%n", fretePortaContainer);
        System.out.println("╚══════════════════════════════════════╝");

        sc.close();
    }
}