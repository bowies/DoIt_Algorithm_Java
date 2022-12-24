package Daily;

public class d_221223{

    /*
     * 검색 알고리즘
     * 키 - 밸류 형태를 설명함
     * 
     * 
     * 
     * 일단 선형 검색부터 설명함
     * 배열을 사용한 듯
     * 선형 검색에서는 검색 실패 / 검색 성공 할 때 종료를 함
     * 루프문 써서 인덱스를 증가시켜서 탐색함
     * 보초값을 대입해서 스캔하는 방식으로 찾는 방식도 있음 
     * 
     * 이진 검색의 경우는 일단 sort가 되어 있어야 함
     * 일단 더 큰 거 >>> 더 작은 거 <<< 로 하기 떄문에 검색 범위 자체가 점점 줄어듬
     * Arrays.binarySearch로 찾는 방법도 제시함.
     * 근데 저거 쓸라면 배열을 오름차순으로 정렬해놓고 써야 함
     * 
     * static 안 붙인 인스턴트 메서드랑
     * static 붙인 클래스 메서드도 설명해 주고
     * 
     * 객체 배열에서 검색하는 것도 가르쳐 주고... 
     * binarySearch에서 인자값 넣는 것도 가르쳐 줌
     * 
     * 
     */

    /*
    class A implements Comparable<A> {
        //이거는 자연스러운 순서 부여를 위해서 사용함

        // 필드, 메소드 등
    
        public int compareTo(A c) {
            // this가 c보다 크면 양수를,
            // this가 c보다 작으면 음수를,
            // this가 c와 같으면 0을 반환합니다.
        }
    
        public boolean equals(Object c) {
            // this가 c와 같으면 true를,
            // this가 c와 같지 않으면 false를 반환합니다.
        }
    }
    */

}
