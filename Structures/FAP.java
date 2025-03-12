
package Structures;
// Lớp trừu tượng FAP định nghĩa một hàng đợi ưu tiên (File à Priorité)
// với các phần tử có khả năng so sánh, đảm bảo thứ tự ưu tiên giữa các phần tử.
public abstract class FAP<E extends Comparable<E>> {
    
    // Trường seq chứa cấu trúc dữ liệu lưu trữ các phần tử của hàng đợi ưu tiên.
    // Cấu trúc này có thể là danh sách liên kết, mảng động, hay bất kỳ dạng sequence nào khác.
    Sequence<E> seq;
    
    // Phương thức trừu tượng ajoute được khai báo để các lớp con triển khai cách thức
    // chèn phần tử mới vào hàng đợi theo thứ tự ưu tiên, tạo nên sự linh hoạt và mở rộng.
    public abstract void ajoute(E element);
    
    // Phương thức extrait lấy và loại bỏ phần tử đầu tiên của hàng đợi ưu tiên,
    // đảm bảo rằng phần tử có độ ưu tiên cao nhất được xử lý trước.
    public E extrait() {
        return seq.extraitTete();
    }
    
    // Phương thức estVide kiểm tra xem hàng đợi ưu tiên có trống không.
    public boolean estVide() {
        return seq.estVide();
    }
}
