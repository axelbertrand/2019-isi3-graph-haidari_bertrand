**Nom/Prénom Etudiant 1 : Axel BERTRAND**

**Nom/Prénom Etudiant 2 : Omran HAIDARI**

# Rapport TP1

## Question 1
*Expliquer le code ajouté*

```java
public List<Node> getAllNodes() {
    return new ArrayList<>(adjacence.keySet());
}

public int getNbNodes() {
    return adjacence.size();
}
```

Pour donner la liste des noeuds du graphe, nous avons utilisé la méthode `keySet` sur l'attribut `adjacence` que nous avons encapsulée dans un objet `ArrayList`. L'attribut `adjacence` représente l'ensemble des noeuds du graphe (contenus dans les clés) avec les arcs qui leur sont liés (contenus dans les valeurs).

Le nombre de noeuds est obtenu en utilisant la méthode `size` qui compte le nombre de pairs clé-valeur.

```java
public List<Node> getAdjNodes(Node _n) {
    //A COMPLETER
    if (!adjacence.containsKey(_n)) {
        return null;
    }

    List<Node> listNode = new ArrayList<>();
    for (Arc arc : adjacence.get(_n)) {
        if (arc.getSource().equals(_n)) {
            listNode.add(arc.getDestination());
        }
    }

    return listNode;
}
```

Avant de récupérer tous les noeuds adjacents d'un noeud donné du graphe, on vérifie que ce noeud existe dans le graphe et on renvoie `null` dans le cas contraire.

Puis, on parcourt tous les arcs liés au noeud `_n` et si la source de l'arc est le noeud `_n` alors on l'ajoute à la liste des noeuds adjacents.

On renvoie cette liste quand on a parcouru tous les arcs.

```java
public String toString() {
    //A COMPLETER

    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("Graph \n");
    for (Node node : adjacence.keySet()) {
        sBuilder.append("[noeud = " + node + " : [");
        String stringifiedArcs = getArc(node).stream().map(Object::toString).collect(joining(", "));
        sBuilder.append(stringifiedArcs + "] \n");
    }

    return sBuilder.toString();
}
```

Dans la méthode `toString`, nous avons utilisé un objet `StringBuilder` pour construire au fur et à mesure la représentation textuelle du graphe. Nous avons utilisé le fait que les méthodes `toString` pour la classe `Node` et `Arc` étaient déjà implémentées.

Nous avons utilisé l'API Stream de Java parcourir et afficher tous les arcs pour chaque noeud.

## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

Pour l'implémentation de la classe UndirectedGraph, nous avons utilisé le Design Pattern Adapter avec délégation pour ainsi éviter la duplication du code.

Nous avons ajouté dans la classe UndirectedGraph un attribut de type Graph et nous avons utilisé les méthodes déjà créées pour implémenter celles de la classe UndirectedGraph.

![Diagramme Adapter Pattern](images/Diagramme_Adapter_Pattern.svg)

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

![Diagramme Iterator Pattern](images/Diagramme_Iterator_Pattern.png)

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

![Diagramme Template_Method Pattern](images/Diagramme_Template_Method_Pattern.png)
