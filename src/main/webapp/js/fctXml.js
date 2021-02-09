/**
 * Cette méthode "Ajax" affiche le XML.
 *
 * On utilise la propriété 'responseText' de l'objet XMLHttpRequest afin
 * de récupérer sous forme de texte le flux envoyé par le serveur.
 */
function listeCrenau ()
	{
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

        //Comment récupérer un magasin en session?
        var mag =  2 //document.getElementById('?').value;
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletCreneau"+mag);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Elément html que l'on va mettre à jour.
			var elt = document.getElementById("tt_zone");
                        elt.innerHTML = xhr.responseText; 
                        // Je colle la réponse textuelle qui m'a été renvoyé directement dans le texte aréa
                        //Si on fait xhr.responseText il envoie la reponse tel quel. 
                        // Si on fait xhr.responseXML c'est un arbre DOM qui est renvoyé
			}
		};
	
	// Envoie de la requête.
	xhr.send();
	}



/**
 * Lancement après le chargement du DOM.
 * Toujours à la fin pour s'assurer que tout le reste à charger au préalable.
 */
document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("bt_zone").addEventListener("click",listeCreneau);
        

});
