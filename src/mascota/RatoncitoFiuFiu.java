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
    private boolean comeMucho;

    public RatoncitoFiuFiu(String nombre, int peso, int hambre, int suciedad, int salud, int energia) {
        // Un objeto mascota.RatoncitoFiuFiu debería informar cuando nace...
        this.nombre = nombre;
        this.edad = 0;
        this.peso = peso;
        this.hambre = hambre;
        this.suciedad = suciedad;
        this.salud = salud;
        this.energia = energia;
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
        if (edad <= 2500) {
            return NINO;
        } else if (edad <= 8000) {
            return ADULTO;
        } else {
            return VIEJO;
        }
    }
    public boolean estasDormido() {
        if (energia <= 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estasEnfermo() {
        return salud <= 25 || comeMucho;
    }

    public boolean estasSucio() {
        return suciedad >= 75;
    }

    public boolean estasMuerto() {
        return salud <= 0;
    }

    public boolean tienesHambre() {
        return hambre >= 75;
    }

    public boolean estasFeliz() {
        return !estasSucio() && !estasEnfermo() && !tienesHambre();
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
            tiempo = 0;
        }
    }
    public boolean tienesQuejas() {
        return !estasFeliz();
    }

    public void alimentar(float cantidadAlimento) {
        if (tienesHambre()){
            aumentarSalud(cantidadAlimento);
            comeMucho = false;
        }else {
            comeMucho = true;
        }
        this.hambre -= cantidadAlimento;
        if (hambre <= 0){
            this.hambre = 0;
        }
        ganarPeso(cantidadAlimento);
    }

    public void curar(float cantidadMedicina) {
        aumentarEnergia(cantidadMedicina);
        aumentarSalud(cantidadMedicina);
    }
}