package com.cg.map.hashmap;

public class HashMap2 {
String Name;
int Age;
public HashMap2(String name, int age) {
	super();
	Name = name;
	Age = age;
}
@Override
public String toString() {
	return "HashMap2 [Name=" + Name + ", Age=" + Age + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Age;
	result = prime * result + ((Name == null) ? 0 : Name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	HashMap2 other = (HashMap2) obj;
	if (Age != other.Age)
		return false;
	if (Name == null) {
		if (other.Name != null)
			return false;
	} else if (!Name.equals(other.Name))
		return false;
	return true;
}


}
