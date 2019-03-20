%houses (nodes)
house(1).
house(2).
house(3).
house(4).
house(5).


%adjacency rules
adjacent(H1,H2) :- house(H1), house(H2), H2 = H1 + 1.
adjacent(H1,H2) :- house(H1), house(H2), H2 = H1 - 1.


%right of rules
right_of(H1, H2) :- house(H1), house(H2), H1 = H2+1.
left_of(H1, H2) :- house(H1), house(H2), H1 = H2-1.

%types of house color
color(red).
color(blue).
color(green).
color(yellow).
color(white).

%types of drinks
drink(tea).
drink(milk).
drink(coffee).
drink(beer).
drink(water).

%types of pets
pet(dog).
pet(cat).
pet(horse).
pet(bird).
pet(fish).

%types of nationalities
race(brit).
race(swede).
race(dane).
race(german).
race(norwegian).

%types of smokes
smoke(pallmall).
smoke(dunhill).
smoke(blend).
smoke(prince).
smoke(bluemaster).



%Basic Rules - Each house has one of each type of variable
has_color(N,red) | has_color(N,blue) | has_color(N,green) | has_color(N,yellow) | has_color(N,white) :- house(N).

-has_color(N1,C) :-
    has_color(N2, C),
    house(N1), house(N2), N1 != N2,
    color(C).

has_race(N, brit) | has_race(N, swede) | has_race(N, dane) | has_race(N, german) | has_race(N, norwegian) :- house(N).

-has_race(N1,C) :-
    has_race(N2, C),
    house(N1), house(N2), N1 != N2,
    race(C).

has_pet(N, dog) | has_pet(N, cat) | has_pet(N, bird) | has_pet(N, fish) | has_pet(N, horse) :- house(N).

-has_pet(N1,C) :-
    has_pet(N2, C),
   house(N1), house(N2), N1 != N2,
    pet(C).

has_smoke(N, pallmall) | has_smoke(N, dunhill) | has_smoke(N, blend) | has_smoke(N, prince) | has_smoke(N, bluemaster) :- house(N).

-has_smoke(N1,C) :-
    has_smoke(N2, C),
    house(N1), house(N2), N1 != N2,
    smoke(C).

has_drink(N, tea) | has_drink(N, milk) | has_drink(N, coffee) | has_drink(N, beer) | has_drink(N, water) :- house(N).

-has_drink(N1,C) :-
    has_drink(N2, C),
    house(N1), house(N2), N1 != N2,
    drink(C).



%Rules from Riddle

%the Brit lives in the red house
has_color(N, red) :- has_race(N, brit), house(N).

%the Swede keeps dogs as pets
has_race(N, swede) :- has_pet(N, dog), house(N).

%the Dane drinks tea
has_race(N, dane) :- has_drink(N, tea), house(N).

%the green house is on the left of the white house
has_color(N1, green) :- has_color(N2, white), house(N1), house(N2), N1 = N2-1.

%the green house's owner drinks coffee
has_color(N, green) :- has_drink(N, coffee), house(N).

%the person who smokes Pall Mall rears birds
has_smoke(N, pallmall) :- has_pet(N, bird), house(N).

%the owner of the yellow house smokes Dunhill
has_color(N, yellow) :- has_smoke(N, dunhill), house(N).

%the man living in the center house drinks milk
has_drink(3, milk).

%the Norwegian lives in the first house
has_race(1, norwegian).

%the man who smokes blends lives next to the one who keeps cats (N2 = 5; left_of(4,5) right
%has_smoke(L, blend) | has_smoke(R, blend) :- has_pet(N2, cat), left_of(L, N2), right_of(R, N2), house(L), house(R), house(N2).

has_smoke(L, blend) :- has_pet(H, cat), left_of(L,H), house(L), house(H).
has_smoke(R, blend) :- has_pet(H, cat), right_of(R,H), house(R), house(H).

%has_smoke(H1, blend) :- has_pet(H2, cat), adjacent(H1,H2), house(H1), house(H2).

%the man who keeps horses lives next to the man who smokes Dunhill
%has_pet(L, horse) | has_pet(R, horse) :- has_smoke(N2, dunhill), left_of(L, N2), right_of(R, N2), house(L), house(R), house(N2).
%has_pet(H1, horse) :- has_smoke(H2, dunhill), adjacent(H1,H2), house(H1), house(H2).

has_pet(L,horse) :- has_smoke(H,dunhill), left_of(L,H), house(L), house(H).
has_pet(R,horse) :- has_smoke(H,dunhill), right_of(R,H), house(R), house(H).

%the owner who smokes BlueMaster drinks beer
has_smoke(N, bluemaster) :- has_drink(N, beer), house(N).

%the German smokes Prince
has_race(N, german) :- has_smoke(N, prince), house(N).

%the Norwegian lives next to the blue house
%has_race(L, norwegian) | has_race(R, norwegian) :- has_color(N2, blue), left_of(L, N2), right_of(R, N2), house(L), house(R), house(N2).

%the man who smokes blend has a neighbor who drinks water
has_smoke(N1, blend) :- has_drink(N2, water), adjacent(N1, N2), house(N1), house(N2), N1 != N2.

#show has_color/2.
#show has_smoke/2.
#show has_race/2.
#show has_pet/2.
#show has_drink/2.







