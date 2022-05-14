/**
 * @file my_string.c
 * @author Owen Huggins
 * @collaborators NAMES OF PEOPLE THAT YOU COLLABORATED WITH HERE
 * @brief Your implementation of these famous 3 string.h library functions!
 *
 * NOTE: NO ARRAY NOTATION IS ALLOWED IN THIS FILE
 *
 * @date 2022-03-28
 */

// DO NOT MODIFY THE INCLUDE(s) LIST
#include <stddef.h>
#include "hw7.h"

/**
 * @brief Calculate the length of a string
 *
 * @param s a constant C string
 * @return size_t the number of characters in the passed in string
 */
size_t my_strlen(const char *s)
{
  #define NUL_Char '\0'
  size_t i = 0;
  const char *str = s;
  while (*(str + i) != NUL_Char) {
      i++;
  }

  return i;

  return 0;
}

/**
 * @brief Compare two strings
 *
 * @param s1 First string to be compared
 * @param s2 Second string to be compared
 * @param n First (at most) n bytes to be compared
 * @return int "less than, equal to, or greater than zero if s1 (or the first n
 * bytes thereof) is found, respectively, to be less than, to match, or be
 * greater than s2"
 */
int my_strncmp(const char *s1, const char *s2, size_t n)
{
  #define NUL_Char '\0'
  size_t i = 0;
  const char *str1 = s1;
  const char *str2 = s2;

  while (i <= n) {

      if (*(str1 + i) - *(str2 + i) < 0) {
        return -1;
    } else if (*(str1 + i) - *(str2 + i) > 0) {
        return 1;
    }

    i++;
  }
  return 0;
}

/**
 * @brief Copy a string
 *
 * @param dest The destination buffer
 * @param src The source to copy from
 * @param n maximum number of bytes to copy
 * @return char* a pointer same as dest
 */
char *my_strncpy(char *dest, const char *src, size_t n)
{
  #define NUL_Char '\0'
  size_t i = 0;
  const char *s = src;
  char *d = dest;
  while (i < n && *(s + 1) != NUL_Char) {
    *(d + i) = *(s + i);
    i++;
  }

  return d;
}
