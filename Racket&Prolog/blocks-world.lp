% Block's World Example
% Gregory Gelfond <ggelfond@unomaha.edu>

% There are seven blocks in this particular domain instance,
% and a location may be either a block, or the table.

block(b0; b1; b2; b3; b4; b5; b6; b7).

location(table).
location(X) :- block(X).

% For the moment we are considering a time horizon of two.

#const n = 1.
step(0..n).

% Fluents
%
% In this domain we consider the following fluents:
% on(B,L) - read as 'block B is on location L'
% above(B,L) - read as 'block B is above location L'
% occupied(B) - read as 'block B is occupied'

fluent(inertial, on(B,L)) :- block(B), location(L).

fluent(defined, above(B,L)) :- block(B), location(L).

fluent(defined, occupied(B)) :- block(B).

fluent(F) :- fluent(defined, F).
fluent(F) :- fluent(inertial, F).

% Initial State

holds(on(b0,table), 0).
holds(on(b1,table), 0).
holds(on(b5,table), 0).
holds(on(b3,b0), 0).
holds(on(b2,b3), 0).
holds(on(b4,b1), 0).
holds(on(b6,b5), 0).
holds(on(b7,b6), 0).

-holds(on(B,L), 0) :- not holds(on(B,L), 0), block(B), location(L).

-holds(on(B,L1), T) :- holds(on(B,L2), T), L1 != L2,
    block(B), location(L1), location(L2), step(T).

% A block is considered to be occupied if some other block is
% on top of it.

holds(occupied(B1), T) :- holds(on(B2,B1), T),
    block(B1), block(B2), step(T).

-holds(occupied(B), T) :- not holds(occupied(B), T),
    block(B), step(T).

% Action Definitions

action(put(B,L)) :- block(B), location(L), B != L.

% put(B,L) causes on(B,L)

holds(on(B,L), T + 1) :- occurs(put(B,L), T),
    block(B), location(L), step(T).

% impossible put(B,L) if occupied(L)

:- occurs(put(B,L), T), holds(occupied(L), T),
   block(B), location(L), step(T).

% impossible put(B,L) if occupied(B)

:- occurs(put(B,L), T), holds(occupied(B), T),
   block(B), location(L), step(T).

% Inertia Axioms

holds(F, T + 1) :-
    holds(F, T), not -holds(F, T + 1),
    fluent(inertial, F), step(T).

-holds(F, T + 1) :-
    -holds(F, T), not holds(F, T + 1),
    fluent(inertial, F), step(T).

% A simple "history"

occurs(put(b2,table), 0).

-occurs(A, T) :- not occurs(A, T),
    action(A), step(T).

% Solver Directives

#show holds/2.
