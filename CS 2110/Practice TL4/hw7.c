/**
 * @file hw7.c
 * @author Owen Huggins
 * @collaborators NAMES OF PEOPLE THAT YOU COLLABORATED WITH HERE
 * @brief structs, pointers, pointer arithmetic, arrays, strings, and macros
 * @date 2022-03-28
 */

// DO NOT MODIFY THE INCLUDE(S) LIST
#include <stdio.h>
#include "hw7.h"
#include "my_string.h"


// Global array of Animal structs
struct animal animals[MAX_ANIMAL_LENGTH];

int size = 0;

/** addAnimal
 *
 * @brief creates a new Animal and adds it to the array of Animal structs, "animals"
 *
 *
 * @param "species" species of the animal being created and added
 *               NOTE: if the length of the species (including the null terminating character)
 *               is above MAX_SPECIES_LENGTH, truncate species to MAX_SPECIES_LENGTH. If the length
 *               is 0, return FAILURE.
 *
 * @param "id" id of the animal being created and added
 * @param "hungerScale" hunger scale of the animal being created and added
 * @param "habitat" habitat of the animal being created and added
 * @return FAILURE on failure, SUCCESS on success
 *         Failure if any of the following are true:
 *         (1) "species" length is 0
 *         (2) "habitat" length is 0
 *         (3) adding the new animal would cause the size of the array "animals" to
 *             exceed MAX_ANIMAL_LENGTH
 *
 */
int addAnimal(const char *species, int id, double hungerScale, const char *habitat)
{

  struct animal a1;
  char s[MAX_SPECIES_LENGTH];
  char h[MAX_HABITAT_LENGTH];
  int speciesLength = my_strlen(species);
  int habitatLength = my_strlen(habitat);

  if (speciesLength == 0 || habitatLength == 0 || size == MAX_ANIMAL_LENGTH) {
    return FAILURE;
  }
  if (speciesLength > MAX_SPECIES_LENGTH) {
    my_strncpy(s, species, (MAX_SPECIES_LENGTH - 1));
    s[MAX_SPECIES_LENGTH] = '\0';
    my_strncpy(a1.species, s, speciesLength);
  } else {
    my_strncpy(a1.species, species, MAX_SPECIES_LENGTH);
  }


  if (my_strlen(habitat) > MAX_HABITAT_LENGTH) {
    my_strncpy(h, habitat, (MAX_HABITAT_LENGTH - 1));
    h[MAX_HABITAT_LENGTH] = '\0';
    my_strncpy(a1.habitat, h, habitatLength);
  } else {
    my_strncpy(a1.habitat, habitat, MAX_HABITAT_LENGTH);
  }

  a1.id = id;
  a1.hungerScale = hungerScale;
  animals[size] = a1;
  size = size + 1;
  return SUCCESS;
}

/** updateAnimalSpecies
 *
 * @brief updates the species of an existing animal in the array of Animal structs, "animals"
 *
 * @param "animal" Animal struct that exists in the array "animals"
 * @param "species" new species of Animal "animal"
 *               NOTE: if the length of species (including the null terminating character)
 *               is above MAX_SPECIES_LENGTH, truncate species to MAX_SPECIES_LENGTH
 * @return FAILURE on failure, SUCCESS on success
 *         Failure if any of the following are true:
 *         (1) the Animal struct "animal" can not be found in the array "animals" based on its id
 */
int updateAnimalSpecies(struct animal animal, const char *species)
{
  int i = 0;
  int speciesLength = my_strlen(species);

  while (i < size) {
      if (animals[i].id == animal.id) {
        if (speciesLength > MAX_SPECIES_LENGTH) {

          my_strncpy(animals[i].species, species, MAX_SPECIES_LENGTH - 1);
          return SUCCESS;
        } else {
          my_strncpy(animals[i].species, species, MAX_SPECIES_LENGTH);
          return SUCCESS;
        }
    }
    i++;
  }

  return FAILURE;
}

/** averageHungerScale
* @brief Search for all animals with the same species and find average the hungerScales
*
* @param "species" Species that you want to find the average hungerScale for
* @return the average hungerScale of the specified species
*         if the species does not exist, return 0.0
*/
double averageHungerScale(const char *species)
{
  int i = 0;
  double ret = 0.0;
  double count;
  int speciesLength = my_strlen(species);
  while (i < size) {
      struct animal a1 = animals[i];
      if (my_strncmp(animals[i].species, species, speciesLength) == 0) {
      ret = ret + a1.hungerScale;
      count = count + 1.0;
    }
    i++;
  }
  if (count > 0) {
    ret = ret / count;
  }

  return ret;
}

/** swapAnimals
 *
 * @brief swaps the position of two Animal structs in the array of Animal structs, "animals"
 *
 * @param "index1" index of the first Animal struct in the array "animals"
 * @param "index2" index of the second Animal struct in the array "animals"
 * @return FAILURE on failure, SUCCESS on success
 *         Failure if any of the following are true:
 *         (1) "index1" and/or "index2" are negative numbers
 *         (2) "index1" and/or "index2" are out of bounds of the array "animals"
 */
int swapAnimals(int index1, int index2)
{
  if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
    return FAILURE;
  }
  struct animal copy = animals[index1];
  struct animal a2 = animals[index2];
  animals[index1] = a2;
  animals[index2] = copy;


  return SUCCESS;
}

/** compareHabitat
 *
 * @brief compares the two Animals animals' habitats (using ASCII)
 *
 * @param "animal1" Animal struct that exists in the array "animals"
 * @param "animal2" Animal struct that exists in the array "animals"
 * @return negative number if animal1 is less than animal2, positive number if animal1 is greater
 *         than animal2, and 0 if animal1 is equal to animal2
 */
int compareHabitat(struct animal animal1, struct animal animal2)
{
  int ret = 0;
  ret = my_strncmp(animal1.habitat, animal2.habitat, MAX_HABITAT_LENGTH);
  return ret;
}

/** removeAnimal
 *
 * @brief removes Animal in the array of Animal structs, "animals", that has the same species
 *
 * @param "animal" Animal struct that exists in the array "animals"
 * @return FAILURE on failure, SUCCESS on success
 *         Failure if any of the following are true:
 *         (1) the Animal struct "animal" can not be found in the array "animals"
 */
int removeAnimal(struct animal animal)
{
  int i = 0;
  int id = animal.id;
  struct animal a1;
  while (i < size) {
    a1 = animals[i];
    if (a1.id == id) {
      while (i < size -1) {
        swapAnimals(i, i + 1);
        i++;
      }
      size = size - 1;
      return SUCCESS;
    }
    i++;
  }
  return FAILURE;

}

/** sortAnimal
 *
 * @brief using the compareHabitat function, sort the Animals in the array of
 * Animal structs, "animals," by the animals' habitat
 * If two animals have the same habitat, place the hungier animal first
 *
 * @param void
 * @return void
 */
void sortAnimalsByHabitat(void)
{

  for (int n = 1; n <= size - 1; n++) {
    int i = n;
    struct animal a1 = animals[i - 1];
    struct animal a2 = animals[i];

    double h1 = a1.hungerScale;
    double h2 = a2.hungerScale;
    while ((!(compareHabitat(animals[i], animals[0]) == 0) && compareHabitat(animals[i], animals[i - 1]) < 0)) {
      swapAnimals(i, (i - 1));

      while (compareHabitat(animals[i], animals[i - 1]) == 0 && h1 > h2) {
        swapAnimals(i, i - 1);
      }
        i--;

    }
  }

}
