enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: Int) {
     init {
        require(nome.isNotBlank()) { "Nome do usuário não pode estar vazio." }
        require(id > 0) { "Id do usuário deve ser positivo e maior que zero." }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel) {
      init {
        require(duracao > 0) { "Duração deve ser positiva." }
    }
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()
    
    val totalDuracao by lazy { conteudos.sumOf { it.duracao } }

    fun matricular(usuario: Usuario) {       
        require(!inscritos.any { it.id == usuario.id }) { "Usuário com id ${usuario.id} já está matriculado." }        
        inscritos.add(usuario)        
    }
    
    fun getAllFormacaoData() {
        println("--------- Formação ($nome) ---------\n") 
        
        conteudos.forEach { item -> 
            println("Conteudo Educacional: ${item.nome} | Duração de ${item.duracao} horas | Nível: ${item.nivel} ")
        }
        
       println("\nTotal de Duração: ${this.totalDuracao} horas")           
        
       println("\n--------- Alunos Matriculados ---------\n") 
       
       println("Nome  |  id") 
       println("____     __\n") 
       inscritos.forEach { item -> 
            println("${item.nome} | ${item.id}")
            
        }
        
    }
}

fun main() {  	
   try {
       val conteudo = mutableListOf<ConteudoEducacional>(
        ConteudoEducacional(nome = "Kotlin", duracao = 100, Nivel.DIFICIL),
        ConteudoEducacional(nome = "Java", duracao = 50, Nivel.BASICO),
        ConteudoEducacional(nome = "Métodologias Ágeis", duracao = 40, Nivel.INTERMEDIARIO)
		)       

       val formacao = Formacao(nome="Bootcamp NTT", conteudo).apply {
           listOf(
                Usuario(nome = "Juan D.", id = 1),
                Usuario(nome = "Juli F.", id = 2),
                Usuario(nome = "Josi F.", id = 3)
           ).forEach(this::matricular)   
           
       }                  
       
       formacao.getAllFormacaoData() 
       
    } catch (e: Exception) {
        println("Erro inesperado: ${e.message}")
    }     

    /* Output
       ** --------- Formação (Bootcamp NTT) ---------

       ** Conteudo Educacional: Kotlin | Duração de 100 horas | Nível: DIFICIL 
       ** Conteudo Educacional: Java | Duração de 50 horas | Nível: BASICO 
       ** Conteudo Educacional: Métodologias Ágeis | Duração de 40 horas | Nível: INTERMEDIARIO 

       **  Total de Duração: 190 horas

       ** --------- Alunos Matriculados ---------

       ** Nome  |  id
       ** ____     __

       ** Juan D. | 1
       ** Juli F. | 2
       ** Josi F. | 3
    */  
}
