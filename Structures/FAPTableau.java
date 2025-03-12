package Structures;

public class FAPTableau<T extends Comparable<T>> extends FAP<T> {
    // Sử dụng SequenceTableau để lưu trữ các phần tử của hàng đợi ưu tiên dưới dạng mảng động (circular buffer)
    SequenceTableau<T> seq;

    // Constructor của FAPTableau, khởi tạo SequenceTableau và gán cho trường seq của lớp cha (FAP)
    public FAPTableau() {
        seq = new SequenceTableau<>();
        super.seq = seq;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ajoute(T element) {
        // Đảm bảo mảng có đủ không gian bằng cách kiểm tra và mở rộng nếu cần
        seq.redimensionne();
        
        // Tính chỉ số 'courant' là vị trí để chèn phần tử mới, dựa trên start và độ dài hiện tại của mảng
        int courant = (seq.start + seq.len) % seq.elements.length;
        
        // Xác định vị trí của phần tử liền trước để so sánh
        int precedent = courant - 1;
        if (precedent < 0)
            precedent = seq.elements.length - 1;
        
        // Dịch chuyển các phần tử trong mảng sang bên phải (theo chiều ngược lại)
        // cho đến khi tìm được vị trí phù hợp để chèn 'element'
        while ((courant != seq.start) && (element.compareTo((T) seq.elements[precedent]) < 0)) {
            // Dịch chuyển phần tử ở vị trí 'precedent' sang vị trí 'courant'
            seq.elements[courant] = seq.elements[precedent];
            
            // Cập nhật vị trí 'courant' và 'precedent' để tiếp tục so sánh
            courant = precedent;
            precedent = courant - 1;
            if (precedent < 0)
                precedent = seq.elements.length - 1;
        }
        
        // Chèn phần tử 'element' vào vị trí đã tìm được
        seq.elements[courant] = element;
        // Tăng độ dài logic của sequence sau khi chèn phần tử
        seq.len++;
    }
}
