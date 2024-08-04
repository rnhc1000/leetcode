package org.ferreiras.leetCode;
class Node {
  Integer data;
  Node next;

  Node(Integer data, Node next) {
    this.data = data;
    next = null;
  }

  Node(Integer data) {
    this.data = data;
  }

  Node() {
  }

  @Override
  public String toString() {
    return "Node{" +
            "data= " + data +
            ", next= " + next +
            '}';
  }
}
public class SinglyLinkedList {
    Integer length = 0;
    Node head = null;
    Node tail = null;


    SinglyLinkedList() {
    }

    public void push(Integer data) {
      Node newOne = new Node(data);
      if (head == null) {
        newOne.next = null;
        head = newOne;
      } else {
        newOne.next = head;
        head = newOne;
      }
    }

    public int getCount() {
      Node node = head;
      int count = 0;
      while (node != null) {
        count++;
        node = node.next;
      }
      return count;
    }

    public Node reverse(Node node) {
      Node prev = null;
      Node next = null;
      Node current = node;
      while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
      node = prev;
      return node;
    }
    void printList(Node node) {
      while (node != null) {
        System.out.print("+" + node.data + " ");
        node = node.next;
      }
      System.out.println();
    }
    @Override
    public String toString() {
      return "SinglyLinkedList{" +
              "length=" + length +
              ", head=" + head +
              ", next=" + new Node().next +
              ", tail=" + tail +
              '}';
    }
  }
