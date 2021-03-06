package biblioj

class Livre {
	String titre
	int nombreExemplaires
	int nombreExemplairesDisponibles
	// relation many-to-many
	static hasMany = [mesAuteurs: Auteur, reservations: Reservation]
	static belongsTo = Reservation
	static fetchMode = [mesAuteurs : 'eager']
	// Relation many-to-one
	TypeDocument typeDocument
	
	static constraints = {
		titre(size:1..300, blank:false, nullable:false)
		nombreExemplaires(min:1, max:9999)
		//nombreExemplairesDisponibles validator: {val, obj -> if(obj.nombreExemplaires < val) ['error']}
		nombreExemplairesDisponibles validator: {val, obj -> obj.nombreExemplaires >= val}
	}
	
	String toString(){
		titre
	}
}
