animal = ['cat', 'snake', 'monkey', 'ant', 'spider']
legs = [4,0,2,4,8]
animal_legs_dict= {}
for i in range(len(animal)):
    animal_legs_dict[legs[i]] = animal[i]
animal_legs_dict['ant'] = 6
print(animal_legs_dict)