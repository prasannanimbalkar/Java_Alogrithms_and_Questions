package org.example.Priority_Queue;

import java.util.Comparator;
import java.util.PriorityQueue;


//https://www.youtube.com/watch?v=32rklOClFpo

//Problem Statement:
//Imagine you have a list of tasks with associated priorities, and you want to execute these tasks in order of their
// priorities. Tasks with higher priorities should be executed before tasks with lower priorities.
// You need to implement a task scheduler using a priority queue to achieve this.

public class PQ_Example {
    public static void main(String[] args) {
        // Create a priority queue to store tasks
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
//        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.reverseOrder());


        // Add tasks with priorities to the queue
        taskQueue.add(new Task("Task A", 2));
        taskQueue.add(new Task("Task B", 1));
        taskQueue.add(new Task("Task C", 3));
        taskQueue.add(new Task("Task D", 2));

        // Execute tasks in order of their priorities
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Executing: " + task.getName() + " (Priority: " + task.getPriority() + ")");
        }
    }

    static class Task implements Comparable<Task> {
        private String name;
        private int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            // Tasks are compared based on their priorities
            return Integer.compare(this.priority, other.priority);
        }
    }
}


//We create a PriorityQueue<Task> to store tasks. The Task class represents a task with a name and a priority.
//
//We add tasks with their priorities to the priority queue using the add method.
//
//The Task class implements the Comparable<Task> interface, allowing us to compare tasks based on their priorities. The compareTo method is used for comparison.
//
//We execute tasks in order of their priorities using a while loop. The poll method is used to remove and return the task with the highest priority from the queue.