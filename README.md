# EAR_project : Gestion d'un établissement
Base de données : 
![database](https://github.com/ouissalhadid2001/EAR_project/assets/127057734/fa0bfc2b-920d-42aa-bcdf-4fdc9de96a97)

Gestion des Roles :




https://github.com/ouissalhadid2001/EAR_project/assets/127057734/270b42a4-a11b-441f-831f-8b3564ffa5e5




Gestion des Filières:



https://github.com/ouissalhadid2001/EAR_project/assets/127057734/6467bf12-86ae-4b75-85e6-e895581389b7




Gestion des étudiants :



https://github.com/ouissalhadid2001/EAR_project/assets/127057734/85de2e75-8646-433b-a8a1-7b96d44bdef1




Gestion des utilisateurs  et affectation des roles :



https://github.com/ouissalhadid2001/EAR_project/assets/127057734/baccb05f-31b2-48f0-b643-fb3e820164a4



Liste des étudiants d'une filières :





https://github.com/ouissalhadid2001/EAR_project/assets/127057734/97b7d67a-6aad-494c-9925-b3c2edb29d1b


-------------------------------Erreurs rencontrées------------------------------------------------
* Les classes services qui implementent IDaoLocal genèrent l'erreur 'More than one Jakarta Enterprise Beans found with interface of type 'dao.IDaoLocal''
Solution proposée : ajouter des interfaces qui hérite de IDaoLocal pour chacune des classes et l'utiliser pour éviter la confusion pendant l'injection de dépendances assurée par l'annotation @EJB
* Problème au niveau du fichier jsp lors de l'utilisation des tags (boucles,condition,etc...) 
Solution adoptée :Ajout des jars jstl.jar,jstl-standard.jar,jstl-impl.jar au niveau du classpath de la partie libraries du projet client Web.
