const express = require('express') // Import thư viện Express
const app = express() // Tạo một ứng dụng Express
const port = 3000 // Đặt cổng cho ứng dụng, ứng dụng sẽ lắng nghe trên cổng 3000
var cors = require('cors'); // Import thư viện CORS để cho phép các nguồn khác truy cập vào API của bạn
app.use(express.json()); // Middleware để parse (xử lý) body yêu cầu dạng JSON
app.use(cors()); // Middleware CORS cho phép các yêu cầu từ các nguồn khác nhau (cross-origin requests)

// Middleware để kiểm tra token trong yêu cầu đến API tài khoản
app.use('/api/account', (req, res, next) => {
    console.log(req.body); // In ra nội dung của body yêu cầu
    if (req.body.token != "") { // Kiểm tra xem token có tồn tại không
        next(); // Nếu có token, tiếp tục xử lý yêu cầu
    } else {
        res.status(401); // Nếu không có token, trả về mã lỗi 401 (Unauthorized)
        res.json({ msg: 'Bad request from middleware' }); // Gửi thông báo lỗi
    }
})

// API tìm kiếm sản phẩm theo tên (dùng query string)
app.get('/catalogsearch/result', (req, res) => {
    let query = req.query.q; // Lấy từ khóa tìm kiếm từ query string (vd: /catalogsearch/result?q=mascara)
    // Thực hiện truy vấn trong cơ sở dữ liệu với từ khóa tìm kiếm 'query'
    console.log(query); // In ra từ khóa tìm kiếm (để kiểm tra)

    // Trả về một danh sách các sản phẩm tìm được dưới dạng JSON
    res.json({
        "products": [ // Dữ liệu giả lập danh sách sản phẩm
            {
                "id": 1,
                "title": "Essence Mascara Lash Princess",
                "description": "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects.",
                "category": "beauty",
                "price": 9.99,
                "discountPercentage": 7.17,
                "rating": 4.94,
                "stock": 5,
                "tags": ["beauty", "mascara"],
                "brand": "Essence",
                "sku": "RCH45Q1A",
                "weight": 2,
                "dimensions": {
                    "width": 23.17,
                    "height": 14.43,
                    "depth": 28.01
                },
                "warrantyInformation": "1 month warranty",
                "shippingInformation": "Ships in 1 month",
                "availabilityStatus": "Low Stock",
                "reviews": [ // Danh sách đánh giá sản phẩm
                    { "rating": 2, "comment": "Very unhappy with my purchase!", "reviewerName": "John Doe" },
                    { "rating": 2, "comment": "Not as described!", "reviewerName": "Nolan Gonzalez" },
                    { "rating": 5, "comment": "Very satisfied!", "reviewerName": "Scarlett Wright" }
                ],
                "returnPolicy": "30 days return policy",
                "minimumOrderQuantity": 24
            }
            // Giả lập trả về 30 sản phẩm
        ],
        "total": 194, // Tổng số sản phẩm
        "skip": 0, // Số lượng sản phẩm bị bỏ qua (thường dùng cho phân trang)
        "limit": 30 // Giới hạn số sản phẩm trả về mỗi lần tìm kiếm
    });
})

// API chỉnh sửa thông tin người dùng
app.put('/api/account/:id', (req, res) => {
    const id = req.params.id; // Lấy ID người dùng từ tham số URL
    const fullname = req.body.fullname; // Lấy thông tin tên đầy đủ từ body yêu cầu
    const address = req.body.address; // Lấy địa chỉ từ body yêu cầu
    // Thực hiện cập nhật thông tin người dùng trong cơ sở dữ liệu ở đây (chưa thực hiện, chỉ là giả lập)
    res.json({ message: `User with ID ${id} updated successfully!` }); // Trả về thông báo thành công
})

// API xóa tài khoản người dùng
app.delete('/api/account/:id', (req, res) => {
    const id = req.params.id; // Lấy ID người dùng từ tham số URL
    // 1. Kiểm tra token trong yêu cầu
    if (!req.body.token) {
        return res.status(401).json({ msg: 'Token required' }); // Nếu không có token, trả về lỗi
    }

    // Giả lập xóa người dùng với ID được cung cấp (thực tế bạn cần kết nối DB để xóa)
    res.json({ msg: `User with ID ${id} deleted successfully!` }); // Trả về thông báo xóa thành công
})

// API thêm mới thông tin người dùng
app.post('/api/user', (req, res) => {
    const { fullname, email, address } = req.body; // Lấy thông tin người dùng từ body yêu cầu
    // Thực hiện thêm người dùng vào cơ sở dữ liệu ở đây (chưa thực hiện, chỉ là giả lập)
    res.status(201).json({ msg: 'User created successfully', user: { fullname, email, address } });
})

// API tìm kiếm thông tin người dùng qua từ khóa
app.get('/api/user/searchbykeyword', (req, res) => {
    const value = req.query.keyword; // Lấy từ khóa tìm kiếm từ query string
    console.log(value); // In ra từ khóa tìm kiếm (để kiểm tra)

    // Giả lập truy vấn trong cơ sở dữ liệu với từ khóa tìm kiếm
    res.json({
        "key": "Ket qua tra ve danh sach nguoi dung", // Trả về kết quả tìm kiếm
    });
})

// API đăng nhập người dùng
app.post('/api/user/login', (req, res) => {
    var email = req.body.email; // Lấy email từ body yêu cầu
    var password = req.body.password; // Lấy password từ body yêu cầu

    // Kiểm tra dữ liệu đăng nhập
    if (email == null || email == "") {
        res.status(400).json({ msg: "Email must input." }); // Nếu email không hợp lệ
    } else if (password == null || password == "") {
        res.status(400).json({ msg: "Password must input." }); // Nếu password không hợp lệ
    } else {
        // Giả lập kiểm tra thông tin đăng nhập với cơ sở dữ liệu
        if (email == 'huce@gmail.com' && password == '123456$@') {
            res.json({
                msg: "Login Success.",
                account: {
                    name: "Dai hoc xay dung", // Thông tin tài khoản
                    avatar: "john.jpg",
                    token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c'
                }
            })
        } else {
            res.status(400).json({ msg: "Login fail." }); // Nếu thông tin đăng nhập sai
        }
    }
})

// Khởi động ứng dụng và lắng nghe yêu cầu tại cổng 3000
app.listen(port, () => {
        console.log(`Example app listening on port ${port}`) // In thông báo khi server đã khởi động thành công
    })
    // phân tích 1 số ra thưaf số nguyên số 
    // rsa