package basic;

/*
 * 	제네릭 클래스 만들기 (1.5부터 지원)
 *  형식)class 클래스명<제네릭타입글자>{		//제네릭 타입글자는 대문자로 하나를 쓴다 
 *  
 *  		제네릭타입글자 변수명;			//변수 선언
 *			...
 *		  
 *			제네릭타입글자 메서드명(매개변수들...){
 *				...
 *
 *				return 값;
 *			}		
 *			반환값자료형 메서드명(제네릭타입글자 변수명,...){	//메서드의 매개변수로 사용할 경우
 *				...
 *			}
 *  	}
 *  
 */

class myGenericClass<T>{
	
	private T val;
	
	public void setVal(T val){		//메서드의 매개변수에 사용
		this.val =val;
	}
	public T getVal(){				//메서드의 반환값으로 사용
		return val; 
	}
	
}





class NonGenericClass{
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
	
}

public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass nc1 = new NonGenericClass();
		NonGenericClass nc2 = new NonGenericClass();
		
		nc1.setVal("가나다라");
		nc2.setVal(100);
		
		String temp = (String)nc1.getVal();
		System.out.println("temp = "+ temp);
		
		int intTemp = (int)nc2.getVal();
		System.out.println("intTemp = "+ intTemp);
		
		//Object 로 잡혀있어서 문법상 문제는 없으나 실제로 돌리면 치명적인 에러가 뜸 
		//왜냐하면 nc1 에는 String을 넣었기 때문이다.
//		int test = (int)nc1.getVal();
//		System.out.println("test = " + test);
		
		
		//------------------------------------------
		
		myGenericClass<String> mgc1 = new myGenericClass<>();
		myGenericClass<Integer>mgc2 = new myGenericClass<>();
		
		mgc1.setVal("가나다라");
		mgc2.setVal(100);
		
		String str = mgc1.getVal();
		int intSome = mgc2.getVal();
		
		System.out.println("str : " + str + "  / " + "intSome : " + intSome);
		
		
//		int test = mgc1.getVal();
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
