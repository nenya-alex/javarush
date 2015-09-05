package com.javarush.test.level17.lesson06.task02;

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым.
*/
//задание принято, но работает не всегда коректно???
// я решил так: int thisProposal = 0; в классе public static class AcceptProposal
public class Solution {
    public static volatile int proposal = 0;

    public static void main(String[] args) {
        new MakeProposal().start();
        new AcceptProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                //System.out.println("proposal 1 = "+proposal);
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;
            //System.out.println("proposal 2 = "+proposal);
            while (thisProposal < 10) {

                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);

                    thisProposal = proposal;

                }
            }
        }
    }
}
