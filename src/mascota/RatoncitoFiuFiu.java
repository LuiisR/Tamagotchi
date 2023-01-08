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
    private int feliz;
    private boolean juegar;
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
        this.feliz = 10;
        duerme = false;
    }


    public String estadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Peso: ").append(peso);
        sb.append("\nHambre: ").append(hambre);
        sb.append("\nSuciedad: ").append(suciedad);
        sb.append("\nSalud: ").append(salud);
        sb.append("\nEnergia: ").append(energia);
        sb.append("\n Felicidad: ").append(feliz);
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
        return feliz >= 7 && !estasEnfermo() && !estasSucio();
    }

    private void ganarPeso(float cantidad) {
        if (!estasEnfermo()){
            this.peso += cantidad;
        }
        if (this.peso <= 20){
            this.peso = 20;
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
        if (salud <= 0){
            this.salud = 0;
        }
    }
    private void aumentarFelicidad (float cantidad){
        this.feliz += cantidad;
        if (feliz >= 10){
            this.feliz = 10;
        }
        if (feliz <= 0){
            this.feliz = 0;
        }
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        tiempo += segundos;
        if (tiempo > 60) {
            this.hambre += 5;
            if (hambre >= 100){
                this.hambre = 100;
            }
            this.suciedad += 5;
            if (suciedad >= 100){
                this.suciedad = 100;
            }
            if (queTramoEdad() ==VEJEZ){
                aumentarSalud(-10);
            }
            aumentarSalud(-5);
            this.energia -= 5;
            if (energia <= 0){
                this.energia = 0;
            }
            if (energia <= 30) {
                duerme = true;
            } else if (energia >= 80){
                duerme = false;
            }
            if ((duerme) && (queTramoEdad() == NINO)){
                aumentarEnergia(5);
            }
            if ((duerme) && (queTramoEdad() == ADULTO)){
                aumentarEnergia(10);
            }
            if ((duerme) && (queTramoEdad() == VIEJO)){
                aumentarEnergia(15);
            }
            if (estasEnfermo()){
                aumentarFelicidad(-1);
            }
            if (estasEnfermo()){
                ganarPeso(-10);
            } else {
                ganarPeso(-5);
            }
            if (estasSucio()){
                aumentarSalud(-10);
            } else{
                aumentarSalud(-5);
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
            aumentarFelicidad(1);
            if (queTramoEdad() == ADULTO){
                this.hambre -= cantidadAlimento;
                if (hambre <= 0){
                    this.hambre = 0;
                }
            } else if (queTramoEdad() == NINO) {
                this.hambre -= (cantidadAlimento - 5);
                if (hambre <= 0){
                    this.hambre = 0;
                }
                else {
                    this.hambre -= (cantidadAlimento - 10);
                    if (hambre <= 0){
                        this.hambre = 0;
                    }
                }
            }
        } else{
           aumentarFelicidad(-1);
           aumentarSalud(-cantidadAlimento);
        }
        if (!estasEnfermo()){
            ganarPeso(cantidadAlimento);
        }
    }

    public void curar(float cantidadMedicina) {
        if (!estasEnfermo()){
            this.salud -= 10;
        }
        else{
            aumentarSalud(cantidadMedicina);
            aumentarFelicidad(1);
            this.salud = 5;
        }
    }
    public boolean jugar (float cantidadDiversion){
        if (estasDormido() || estasEnfermo() || estasSucio() || tienesHambre()){
            juegar = false;
            return false;
        } else {
            this.energia -= cantidadDiversion;
            this.hambre += cantidadDiversion;
            this.suciedad += 5;
            aumentarFelicidad(2);
            juegar = true;
            return true;
        }
    }
    public boolean estaJuegando(){
        return juegar;
    }
    public boolean matar(){
        this.salud = 0;
        return true;
    }
}