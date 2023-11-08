# EAR_project : Gestion d'un établissement
Base de données : 
![database](https://github.com/ouissalhadid2001/EAR_project/assets/127057734/819573f9-b1d1-4b91-a2c7-ef47cff27d52)

Gestion des Roles :


https://github.com/ouissalhadid2001/EAR_project/assets/127057734/68e8afc3-47a3-4ed4-9b5b-886a2bc5bf9b



Gestion des Filières:


https://github.com/ouissalhadid2001/EAR_project/assets/127057734/9d635d92-aa30-4984-a0a8-afbb76ebfa2a


Gestion des étudiants :


https://github.com/ouissalhadid2001/EAR_project/assets/127057734/aaf41555-25f4-4ff5-ab10-9c0918520548


Gestion des utilisateurs  et affectation des roles :


https://github.com/ouissalhadid2001/EAR_project/assets/127057734/91f46c35-e36e-4b85-b573-f0a0e3255dd7

Liste des étudiants d'une filières :



https://github.com/ouissalhadid2001/EAR_project/assets/127057734/0464da9d-5de6-44fc-a964-4d9623262acf

-------------------------------Erreurs rencontrées------------------------------------------------
* Les classes services qui implementent IDaoLocal genèrent l'erreur 'More than one Jakarta Enterprise Beans found with interface of type 'dao.IDaoLocal''
Solution proposée : ajouter des interfaces qui hérite de IDaoLocal pour chacune des classes et l'utiliser pour éviter la confusion pendant l'injection de dépendances assurée par l'annotation @EJB
* Problème au niveau du fichier jsp lors de l'utilisation des tags (boucles,condition,etc...) 
Solution adoptée :Ajout des jars jstl.jar,jstl-standard.jar,jstl-impl.jar au niveau du classpath de la partie libraries du projet client Web.
