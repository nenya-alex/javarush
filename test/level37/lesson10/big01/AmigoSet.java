package com.javarush.test.level37.lesson10.big01;



import java.io.*;
import java.util.*;

/**
 * Created by Admin on 21.07.15.
 */
public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    transient private final  static Object PRESENT = new Object();
    transient private HashMap<E,Object> map;


    @Override
    public String toString() {
        return "AmigoSet" +
                 map.keySet();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>((int) Math.max(16, collection.size()/.75f));
        HashMap<E,Object> mapHelp = new HashMap<>();
        Iterator<? extends E> iter = collection.iterator();
        while (iter.hasNext()){
            mapHelp.put(iter.next(), PRESENT);
        }
        this.map.putAll(mapHelp);
    }

    public AmigoSet() {
        this.map = new HashMap<>();
    }



    public boolean add(Object e) {
        int k= map.size();
        map.put((E) e,PRESENT);
        if (map.size()==(k+1))
            return true;
        else
            return false;
    }


    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    public boolean isEmpty()
    {
        return this.map.isEmpty();
    }

    public boolean contains(Object o)
    {
        return this.map.containsKey(o);
    }

    public void clear(){
        this.map.clear();
    }

    public boolean remove(Object o)
    {
        int k= map.size();
        map.remove(o);
        if (map.size()==k-1)
            return true;
        else
            return false;
    }

    @Override
    public Object clone() throws InternalError {

        Set<E> set = new AmigoSet<E>();
        HashMap<E,Object> mapHelp = (HashMap<E, Object>) this.map.clone();
        for (Map.Entry<E, Object> it: mapHelp.entrySet())
        {
            set.add(it.getKey());
        }
        return set;
    }

    private void writeObject (ObjectOutputStream out) throws IOException {
        //out.defaultWriteObject();
        Set<E> set = new HashSet<>();

        for (Map.Entry<E, Object> it: map.entrySet())
        {
            set.add(it.getKey());
        }

        out.writeObject(set);
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException {
        //in.defaultReadObject();

        Object set = in.readObject();

        Object capacity = in.readObject();

        Object loadFactor = in.readObject();



        this.map = new HashMap<>((Integer) capacity, (Float) loadFactor);

        HashMap<E,Object> mapHelp = new HashMap<>();
        Iterator<E> iter = new HashSet<>((Collection<? extends E>) set).iterator();
        while (iter.hasNext()){
            mapHelp.put(iter.next(), PRESENT);
        }
        this.map.putAll(mapHelp);
    }


}
