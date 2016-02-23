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
			def u = Usuario.findByEmail(params.email)
			if (u){
				session.user = u
				redirect(controller:'mapa')
			}else{
				flash.message = "Usuario no encontrado"
				redirect(controller:'mapa')
			}
		}else if (session.user) {
            // usuario ya encontrado
            redirect(controller:'mapa')
        }
		render (view:"registro", model: [userList:Usuario.list()])
    }
 
    def logout() {
        session.invalidate()
        redirect(controller:'mapa')
    }
}

