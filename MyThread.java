public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            while(true) {
                synchronized(Biblioteca.getInstance()) {
                    System.out.println("Numarul cartilor din biblioteca este " + Biblioteca.nrCarti);
                    Thread.sleep(50000); 
                }
            } 
        }catch(InterruptedException e) {
            e.printStackTrace();
      
        }
        
    }
}