// READ THE HEADER FILE FOR MORE DOCUMENTATION
#include "tl04.h"


/**
 * \brief Pointers to the ends of the list
 *
 * These pointers keep track of where the singly-linked list is in memory. The
 * [queue_head] pointer points to the first node of the list, and [queue_tail]
 * likewise points to the last.
 *
 * Initially, both of these pointers are `NULL`. The list is initially empty, so
 * there is no first or last node.
 *
 * \property extern queue_node_t *queue_head
 * \property extern queue_node_t *queue_tail
 */
struct queue_node_t *queue_head = NULL;
struct queue_node_t *queue_tail = NULL;


/**
 * \brief Add students to the queue
 *
 * This function will be called by client code to add a student to the end of
 * the queue. The caller will supply the data of the student to add.
 *
 * This function should wrap the [data] in a [queue_node_t] on the heap, and
 * deep-copy all the other data. In particular, the name of the student should
 * be moved onto the heap as well.
 *
 * This function should return `SUCCESS` if the student was added successfully.
 * If it fails, it should return `FAILURE` and leave the list unchanged. It
 * should fail if and only if:
 * * `malloc` fails,
 * * the student's name is `NULL`, or
 * * the student's name is an empty string.
 *
 * \param[in] data Data of the student to enqueue
 * \return Whether the student was successfully added
 */
int queue_add(struct student_t data) {
    struct queue_node_t *new;
    new = (struct queue_node_t *) malloc(sizeof(struct queue_node_t));
    if (new == NULL) {
      return FAILURE;
    }

    if (data.name == NULL || strcmp(data.name, "") == 0) {
      free(new);
      return FAILURE;
    }
    new -> data.name = (char *) malloc(strlen(data.name) + 1);
    if (new -> data.name == NULL) {
      free(new);
      return FAILURE;
    }
    new -> next = NULL;
    struct student_t *student;
    student = (struct student_t *) malloc(sizeof(struct student_t));
    if (student == NULL) {
      free(new -> next);
      free(new -> data.name);
      free(new);
      free(student);
      return FAILURE;

    }
    student -> assignment = data.assignment;
    new -> data = *student;
    free(student);
    new -> next = queue_tail -> next;
    queue_tail -> data.name = (char *) malloc(strlen(data.name) + 1);
    if (queue_tail -> data.name == NULL) {
      free(queue_tail);
      return FAILURE;
    }
    queue_tail -> data.name = data.name;

    return SUCCESS;


}

/**
 * \brief Remove students from the queue
 *
 * This function will be called by client code to remove a student from the
 * front the queue. It will return whether a student was removed successfully,
 * and the data removed in that case.
 *
 * The way this function returns the data is somewhat strange. To get around the
 * limitation that functions may only have one return value, the caller will
 * pass in a pointer where the student's data should be stored. This function
 * will store the returned data at that pointer. Independently, it will return
 * whether it succeeded via the normal path.
 *
 * If this function succeeds, it should return `SUCCESS` and modify `*data` to
 * be the data of the student removed. If it fails, it should return `FAILURE`
 * and leave both the list and `*data` unchanged. It should fail if and only if:
 * * [data] is `NULL`, or
 * * the list is empty.
 *
 * \param[out] data Where to put the data of the removed student
 * \return Whether a student was successfully removed
 */
int queue_remove(struct student_t *data) {
    // TODO
    UNUSED(data);
    return FAILURE;
}
