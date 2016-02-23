package bikeapp

class UsuarioController {

    def index() {
    }
    
    def registro() {
    	render(params)
    	def users = new Usuario(params)
    	users.save(failOnError: true)
    	render (view:"registro", model: [userList:Usuario.list()])
    }
	
	def login(){
		
		if (request.method == 'POST'){
			def u = Usuario.findByEmailAndContrasena(params.email,params.contraseña)
			if (u){
				flash.message = "Usuario hola"
				session.user = u
				redirect(uri:'/')
			}else{
				flash.message = "Usuario no encontrado"
				redirect(uri:'/')
			}
		}else if (session.user) {
            // usuario ya encontrado
            redirect(controller:'mapa')
        }
    }
 
    def logout() {
        session.invalidate()
        redirect(uri:'/')
    }
}

