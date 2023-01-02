package mascota;

public class RatoncitoFiuFiu {
    private String nombre;
    private int edad;
    private int peso;
    private int hambre;
    private int suciedad;
    private int salud;
    private int energia;
    private int tiempo;
    private final int NINO = 0;
    private final int ADULTO = 1;
    private final int VIEJO = 2;
    private boolean duerme;
    private final int INFANCIA = 1000;
    private final int ADULTEZ = 5000;
    private final int VEJEZ = 8500;

    public RatoncitoFiuFiu(String nombre, int peso, int hambre, int suciedad, int salud, int energia) {
        // Un objeto mascota.RatoncitoFiuFiu debería informar cuando nace...
        this.nombre = nombre;
        this.edad = 0;
        this.peso = peso;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.salud = salud;
        this.energia = energia;
        duerme = false;
    }


    public String estadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Peso: ").append(peso);
        sb.append("\nHambre: ").append(hambre);
        sb.append("\nSuciedad: ").append(suciedad);
        sb.append("\nSalud: ").append(salud);
        sb.append("\nEnergia: ").append(energia);
        return sb.toString();
    }

    public void limpiar(float esfuerzoHigienico) {
        this.suciedad -= esfuerzoHigienico;
        if (suciedad <= 0){
            this.suciedad = 0;
        }
    }

    public int queTramoEdad() {
        if (edad <= INFANCIA) {
            return NINO;
        } else if (edad <= ADULTEZ) {
            return ADULTO;
        } else {
            return VIEJO;
        }
    }
    public boolean estasDormido() {
        if (energia <= 30) {
            duerme = true;
        } else if (energia >= 80){
            duerme = false;
        }
        return duerme;
    }

    public boolean estasEnfermo() {
        return salud <= 25;
    }

    public boolean estasSucio() {
        return suciedad >= 75;
    }

    public boolean estasMuerto() {
        return salud <= 0 || edad > VEJEZ;
    }

    public boolean tienesHambre() {
        return hambre >= 75;
    }

    public boolean estasFeliz() {
        return !estasSucio() && !tienesHambre();
    }

    private void ganarPeso(float cantidad) {
        if (!estasEnfermo()){
            this.peso += cantidad;
        }
    }

    private void aumentarEnergia(float cantidad) {
        this.energia += cantidad;
        if (energia >= 100){
            this.energia = 100;
        }
        if (energia <= 30) {
            duerme = true;
        } else if (energia >= 80){
            duerme = false;
        }
    }

    private void aumentarSalud(float cantidad) {
        this.salud += cantidad;
        if (salud >= 100){
            this.salud = 100;
        }
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        tiempo += segundos;
        if (tiempo > 5) {
            this.hambre += 5;
            if (hambre >= 100){
                this.hambre = 100;
            }
            this.suciedad += 5;
            if (suciedad >= 100){
                this.suciedad = 100;
            }
            this.salud -= 5;
            if (salud <= 0){
                this.salud = 0;
            }
            this.energia -= 5;
            if (energia <= 0){
                this.energia = 0;
            }
            if (energia <= 30) {
                duerme = true;
            } else if (energia >= 80){
                duerme = false;
            }
            if (duerme){
                aumentarEnergia(15);
            }
            tiempo = 0;
        }
    }
    public boolean tienesQuejas() {
        return !estasFeliz();
    }

    public void alimentar(float cantidadAlimento) {
        if (tienesHambre()) {
            aumentarSalud(cantidadAlimento);
        }
        this.hambre -= cantidadAlimento;
        if (hambre <= 0){
            this.hambre = 0;
        }
        if (!estasEnfermo()){
            ganarPeso(cantidadAlimento);
        }
    }

    public void curar(float cantidadMedicina) {
        aumentarSalud(cantidadMedicina);
    }
}