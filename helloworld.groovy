println "Hello World!"
class Account {
    String name
    int value
    private String password
    
    String toString(){
		"${name}	${value}	${password}"
    }
}
Account a = new Account(name:"arboc")
println a
println a.getName()
println a.name
