male(bill).
male(bob).
male(mike).
male(rich).
male(sam).

female(mary).
female(kathy).
female(patty).
female(susan).

parent(mary, bill).
parent(bob, bill).
parent(kathy, mary).
parent(mike, mary).
parent(patty, bob).
parent(rich, bob).
parent(patty, jane).
parent(rich, jane).
parent(susan, rich).
parent(sam, rich).

child(X,Y) :- parent(Y,X).

mother(X,Y) :-
    parent(X,Y), female(X).

father(X,Y) :-
    parent(X,Y), male(X).

son(X,Y) :-
    child(X,Y), male(X).

daughter(X,Y) :-
    child(X,Y), female(X).

ancestor(X, Y) :-
    parent(X, Y).

ancestor(X, Y) :-
    parent(Z, Y),
    ancestor(X, Z).
