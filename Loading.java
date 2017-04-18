package DBMS;

/**
 * Created by Pawan on 15-04-2017.
 */
public class Loading extends Thread {

    private String thread;

    Loading(String thread)
    {
        this.thread=thread;
    }

    public void run(){
        System.out.println("Sleep");
        waiting();
        try{sleep(10000);}
        catch(Exception e){e.printStackTrace();}
        notifying();
        System.out.println("End Loading");
    }

    public void waiting()
    {
        synchronized (thread)
        {
            try {thread.wait();}
            catch(Exception e){e.printStackTrace();}
        }
    }

    public void notifying()
    {
        synchronized (thread)
        {
            try {thread.notifyAll();}
            catch(Exception e){e.printStackTrace();}
        }
    }
}
