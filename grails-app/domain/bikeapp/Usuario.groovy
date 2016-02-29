package bikeapp
import groovy.transform.ToString

@ToString
class Usuario {

	static hasMany = [puntos: PuntoInteres]

	String usuario
	String email
	String contraseña
	String fecha
	String intereses

    static constraints = {
    	intereses(nullable: true)
    }
}
