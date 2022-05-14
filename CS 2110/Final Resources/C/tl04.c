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
queue_node_t *queue_head = NULL;
queue_node_t *queue_tail = NULL;


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
int queue_add(student_t data) {
    // Ensure the name passed in is not `NULL`
    if (data.name == NULL) {
        return FAILURE;
    }
    // Ensure the name passed in is not an empty string
    if (data.name[0] == '\0') {
        return FAILURE;
    }

    // Deep copy the name onto the heap
    // Die on failure
    char *new_name = malloc(strlen(data.name) + 1);
    if (new_name == NULL) {
        return FAILURE;
    }
    strcpy(new_name, data.name);

    // Create the node on the heap
    // Die on failure, remembering to `free` the name we allocated
    queue_node_t *new_node = malloc(sizeof(queue_node_t));
    if (new_node == NULL) {
        free(new_name);
        return FAILURE;
    }

    // We're home free
    // Just set all the fields appropriately
    // Remember that we deep copied the name
    new_node->next = NULL;
    new_node->data.name = new_name;
    new_node->data.assignment = data.assignment;

    // Insert the node into the list
    // Take care of the case the list is empty
    if (queue_tail == NULL) {
        queue_tail = new_node;
        queue_head = new_node;
    } else {
        queue_tail->next = new_node;
        queue_tail = new_node;
    }

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
int queue_remove(student_t *data) {
    // Ensure the pointer passed in is not `NULL`
    if (data == NULL) {
        return FAILURE;
    }
    // Ensure the list is not empty
    if (queue_head == NULL) {
        return FAILURE;
    }

    // Get the current head
    // Use a pointer because we need to free later
    queue_node_t *old_head = queue_head;

    // Copy over the data
    // Don't free the string since that's still reachable
    *data = queue_head->data;

    // Move the head up by one
    // Take care of the case the list is empty
    queue_head = queue_head->next;
    if (queue_head == NULL) {
        queue_tail = NULL;
    }

    // Free the old structure
    // Return
    free(old_head);
    return SUCCESS;
}
