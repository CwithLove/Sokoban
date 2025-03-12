package Structures;

public class FAPListe<E extends Comparable<E>> extends FAP<E> {
    // Dùng SequenceListe để lưu trữ các phần tử của hàng đợi ưu tiên dưới dạng danh sách liên kết.
    SequenceListe<E> seq;

    // Constructor của FAPListe, đảm bảo rằng các thành phần của lớp con và lớp cha đều được khởi tạo đúng cách.
    public FAPListe() {
        // Khởi tạo đối tượng SequenceListe, tạo nền tảng cho việc chèn và duy trì thứ tự ưu tiên.
        seq = new SequenceListe<>();
        // Gán đối tượng SequenceListe vừa khởi tạo cho trường seq trong lớp cha FAP,
        // đảm bảo tính nhất quán giữa lớp con và lớp cha.
        super.seq = seq;
    }

    // Phương thức thêm phần tử mới vào hàng đợi ưu tiên theo thứ tự tăng dần.
    @Override
    public void ajoute(E element) {
        // Khai báo các con trỏ để duyệt danh sách:
        // 'precedent' sẽ lưu trữ nút đứng trước nút hiện tại,
        // 'courant' lưu trữ nút hiện tại đang được duyệt.
        Noeud<E> precedent, courant;
        precedent = null;
        courant = seq.tete;
        
        // Duyệt qua danh sách cho đến khi tìm được vị trí chèn phù hợp,
        // tức là khi phần tử mới không còn lớn hơn giá trị của nút hiện tại.
        while ((courant != null) && (element.compareTo(courant.val) > 0)) {
            precedent = courant;
            courant = courant.suiv;
        }

        // Tạo một nút mới chứa phần tử 'element',
        // nút mới sẽ trỏ tới nút hiện tại (courant) để duy trì liên kết danh sách.
        Noeud<E> m = new Noeud<>(element, courant);
        
        // Nếu không có nút nào đứng trước (precedent == null),
        // thì nút mới sẽ trở thành nút đầu tiên của danh sách.
        if (precedent == null) {
            seq.tete = m;
        } else {
            // Ngược lại, chèn nút mới vào sau nút 'precedent'.
            precedent.suiv = m;
        }
        
        // Nếu 'courant' là null, điều này có nghĩa là nút mới được chèn ở cuối danh sách,
        // nên cập nhật lại con trỏ 'queue' (đuôi danh sách).
        if (courant == null)
            seq.queue = m;
    }
}
