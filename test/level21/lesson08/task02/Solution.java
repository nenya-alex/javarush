package com.javarush.test.level21.lesson08.task02;

import java.util.Arrays;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        //Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree tree = new Tree("willow", null);
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }



    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException, NullPointerException
        {
            Tree clone = (Tree) super.clone();
            if(this.getBranches() != null){
                String[] branches = new String[this.getBranches().length];
                for (int i = 0; i < this.getBranches().length; i++)
                {
                    branches[i] = new String(this.getBranches()[i]);
                }
                //System.out.println(Arrays.toString(branches));
                clone.branches=branches;
                Tree newTree = new Tree(new String(clone.getName()), branches);
                clone = newTree;
            }

            return clone;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
