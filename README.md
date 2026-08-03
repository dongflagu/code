# HUODUAN 综合项目

这是一个由三个相互独立的子项目组成的学习与练习项目集合：

| 子项目 | 类型 | 主要用途 |
| --- | --- | --- |
| `demo` | Spring Boot 后端 | 提供用户/任务数据的 RESTful 增删改查接口 |
| `HTML` | 原生 HTML 页面 | 展示个人信息、成绩、表单校验和图片内容 |
| `my-vue-page` | Vue 3 前端 | 模拟校园综合页面，包含首页、教务页面和任务管理页面 |

其中，`demo` 是独立的后端接口项目；`HTML` 和 `my-vue-page` 目前主要是前端练习项目。三个项目可以分别运行，也可以在后续开发中将 Vue 页面接入 Spring Boot 接口。

## 一、项目功能

### 1. Spring Boot 后端：`demo`

该项目实现了一个基于 MySQL 的用户信息管理接口。代码中的实体名称仍然使用 `Task`，接口前缀为 `/api/tasks`，但数据实际用于保存用户信息：

| 字段 | 当前含义 |
| --- | --- |
| `id` | 用户编号，MySQL 自增 |
| `title` | 用户姓名 |
| `status` | 用户方向、学校或分类信息 |

主要能力包括：

- 查询全部用户
- 按姓名或方向进行模糊查询
- 根据 ID 查询用户
- 新增用户
- 修改用户
- 删除用户
- 使用统一的 `code`、`data`、`msg` 格式返回结果
- 使用 MyBatis-Plus 简化数据库访问

当前后端接口主要用于接口测试，项目中可以使用 `test.http`、Postman 或其他 HTTP 客户端发送请求。

### 2. 原生 HTML 页面：`HTML`

该页面是一个个人信息展示和前端基础练习页面，打开 `test.html` 后可以看到：

- 个人姓名、专业、方向及联系方式
- 个人头像和摄影图片
- GitHub 仓库跳转链接
- 个人爱好信息
- 课程成绩表格
- 期末成绩切换按钮
- 姓名、学号、自我介绍和城市选择表单
- 简单的表单输入校验和提交提示

页面中的表单数据只在浏览器端校验和弹窗展示，不会保存到数据库，也不会发送到后端。

### 3. Vue 前端：`my-vue-page`

该项目是一个 Vue 3 + Vite 的前端练习项目，用于模拟一个简单的校园综合页面。

页面路由如下：

| 路由 | 页面 | 用途 |
| --- | --- | --- |
| `/` | `Home.vue` | 输入姓名并跳转到教务页面 |
| `/edu` | `EduPage.vue` | 模拟教务页面，展示成绩、课程和登录表单 |
| `/todo` | `Todo.vue` | 任务管理页面，支持添加、完成、编辑和删除任务 |

主要功能包括：

- 页面路由跳转
- 成绩展示和总分计算
- 根据成绩显示不同评价
- 教务信息表单填写和基础校验
- 登录成功提示和上次登录信息展示
- 任务新增、编辑、删除
- 任务完成状态切换
- 按“全部、未完成、已完成”筛选任务
- 使用 Element Plus 提供表格、按钮、弹窗、消息提示等组件
- 读取 `public/testData.json` 作为本地 JSON 练习数据

该项目当前主要使用本地数据，任务操作不会持久化到数据库。`src/mock/index,js` 中虽然保留了 Mock.js 示例，但当前没有在 `src/main.js` 中启用。

## 二、技术栈

### 后端技术栈

- Java 17
- Spring Boot `4.0.7`
- Spring Web MVC
- Maven
- MyBatis-Plus `3.5.17`
- MySQL
- Lombok

后端采用典型的分层结构：

```text
Controller  接收 HTTP 请求
    |
Service     处理业务逻辑
    |
Mapper      访问数据库
    |
MySQL       保存 task 表数据
```

### 原生 HTML 技术栈

- HTML5
- CSS3
- JavaScript
- 浏览器原生 DOM API
- 浏览器 `alert` 弹窗

### Vue 技术栈

- Vue 3
- Vite
- Vue Router 4
- Element Plus
- Mock.js，当前仅保留示例代码
- Axios，代码中用于读取本地 JSON

## 三、目录结构

```text
HUODUAN/
├─ demo/                    Spring Boot 后端项目
│  ├─ src/main/java/        Java 源代码
│  ├─ src/main/resources/   application.yml
│  ├─ pom.xml               Maven 配置
│  └─ test.http              接口测试请求示例
├─ HTML/                    原生 HTML 页面
│  ├─ test.html             页面入口
│  ├─ style.css             页面样式
│  ├─ test.js               页面交互逻辑
│  └─ *.jpg, *.png          页面图片资源
├─ my-vue-page/             Vue 3 前端项目
│  ├─ src/views/             页面组件
│  ├─ src/components/        可复用组件
│  ├─ src/router/             路由配置
│  ├─ src/mock/               Mock 示例
│  ├─ public/                 静态资源和 JSON 数据
│  ├─ package.json            npm 脚本和依赖
│  └─ vite.config.js          Vite 配置
└─ README.md                 项目说明文档
```

## 四、环境要求

建议使用以下环境：

- Windows、macOS 或 Linux
- JDK 17 或更高版本
- Maven 3.9+，或使用项目自带的 Maven Wrapper
- Node.js 18+，建议使用当前稳定版
- npm 9+
- MySQL 8.x

检查环境：

```bash
java -version
mvn -version
node -v
npm -v
mysql --version
```

## 五、后端部署与运行

### 1. 创建数据库

后端默认连接以下数据库：

```text
数据库：vue_task_db
地址：localhost:3306
用户名：root
密码：123456
```

先创建数据库：

```sql
CREATE DATABASE vue_task_db
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
```

然后创建 `task` 表：

```sql
USE vue_task_db;

CREATE TABLE task (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  title VARCHAR(100) NOT NULL COMMENT '用户姓名',
  status VARCHAR(255) DEFAULT NULL COMMENT '方向、学校或分类',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

可以插入几条测试数据：

```sql
INSERT INTO task (title, status) VALUES
  ('王浩宇', '广州华立学院'),
  ('李明', '广东科技学院'),
  ('张三', '广州城市理工学院');
```

### 2. 修改数据库配置

配置文件为 `demo/src/main/resources/application.yml`。如果本机 MySQL 用户名或密码不同，请修改对应配置：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/vue_task_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
```

生产环境不建议将数据库密码直接写入配置文件，可以改为环境变量：

```yaml
spring:
  datasource:
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD}
```

### 3. 启动开发环境

进入后端目录：

```bash
cd demo
```

使用 Maven Wrapper 启动：

```bash
./mvnw spring-boot:run
```

Windows PowerShell 可以使用：

```powershell
.\mvnw.cmd spring-boot:run
```

如果本机已安装 Maven，也可以使用：

```bash
mvn spring-boot:run
```

启动成功后，后端地址为：

```text
http://localhost:8081
```

### 4. 打包并部署

```bash
cd demo
mvn clean package -DskipTests
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

服务器部署时需要确保：

- JDK 17 已安装
- MySQL 已启动并允许后端访问
- 数据库配置与服务器实际环境一致
- 防火墙或安全组允许业务端口访问

端口可以在 `application.yml` 中修改：

```yaml
server:
  port: 8081
```

## 六、原生 HTML 页面部署

### 1. 本地直接打开

进入 `HTML` 目录，直接用浏览器打开 `test.html` 即可：

```text
D:\HUODUAN\HTML\test.html
```

由于页面使用相对路径加载 `style.css`、`test.js` 和图片资源，部署时必须保持这些文件的相对位置不变。

### 2. 使用静态文件服务器

为了避免浏览器对本地文件访问的限制，建议使用静态服务器运行。例如使用 Node.js：

```bash
npx serve HTML
```

启动后根据终端提示访问对应地址即可。

### 3. 使用 Nginx 部署

将 `HTML` 目录中的文件复制到 Nginx 的静态资源目录，例如：

```text
/usr/share/nginx/html/huoduan/
```

然后访问：

```text
http://服务器地址/huoduan/test.html
```

## 七、Vue 前端部署与运行

### 1. 安装依赖

进入 Vue 项目目录：

```bash
cd my-vue-page
npm install
```

Windows PowerShell 如果执行 `npm` 被脚本策略拦截，可以使用：

```powershell
npm.cmd install
```

### 2. 启动开发服务器

```bash
npm run dev
```

或在 Windows PowerShell 中使用：

```powershell
npm.cmd run dev
```

Vite 启动后，访问终端输出的地址，通常为：

```text
http://localhost:5173
```

### 3. 构建生产文件

```bash
npm run build
```

构建产物默认生成在：

```text
my-vue-page/dist/
```

可以使用 Vite 预览构建结果：

```bash
npm run preview
```

### 4. 使用 Nginx 部署

将 `dist` 目录中的全部文件复制到 Nginx 静态目录，并配置 Vue Router 的回退规则：

```nginx
server {
    listen 80;
    server_name localhost;

    root /var/www/huoduan/dist;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }
}
```

`try_files` 很重要，因为 Vue 使用了 `createWebHistory()`。如果直接访问 `/edu` 或 `/todo` 时 Nginx 没有回退到 `index.html`，刷新页面可能会出现 404。

## 八、后端接口说明

后端统一前缀为：

```text
http://localhost:8081/api/tasks
```

### 查询全部数据

```http
GET /api/tasks
```

可选查询条件：

```http
GET /api/tasks?title=王&status=广州
```

### 根据 ID 查询

```http
GET /api/tasks/{id}
```

### 模糊搜索

```http
GET /api/tasks/search?name=王&direction=广州
```

其中 `name` 对应 `title` 字段，`direction` 对应 `status` 字段。

### 新增数据

```http
POST /api/tasks
Content-Type: application/json

{
  "title": "王浩宇",
  "status": "广州华立学院"
}
```

新增时不需要传 `id`，数据库会自动生成自增编号。

### 修改数据

```http
PUT /api/tasks/{id}
Content-Type: application/json

{
  "title": "王浩宇",
  "status": "广东科技学院"
}
```

### 删除数据

```http
DELETE /api/tasks/{id}
```

### 返回格式

```json
{
  "code": 200,
  "data": [],
  "msg": "操作成功"
}
```

## 九、前后端联调说明

目前三个子项目并没有完全打通成一个可直接上线的整体：

- `my-vue-page` 的任务页面使用组件内本地数组，暂时不会请求 `demo` 的 `/api/tasks` 接口。
- Vue 项目开启了 `axios` 调用，但 `axios` 当前声明在仓库根目录的 `package.json` 中，而不是 `my-vue-page/package.json` 中。
- Vue 的 Mock 示例文件名为 `src/mock/index,js`，且在 `src/main.js` 中处于注释状态，因此当前不会自动启用 Mock 接口。
- Vue 项目中的部分历史文件存在中文乱码或练习代码残留，若构建失败，应优先检查文件编码、未使用依赖和语法问题。

如果要将 Vue 任务页面接入 Spring Boot，建议按以下方式改造：

1. 在 `my-vue-page` 项目中明确安装并声明 Axios：

   ```bash
   cd my-vue-page
   npm install axios
   ```

2. 将任务列表、添加、编辑、删除操作改为请求 `/api/tasks`。
3. 开发环境通过 Vite 配置代理，将 `/api` 转发到 `http://localhost:8081`，避免跨域。
4. 生产环境让前端和后端使用同域名，或在 Nginx 中配置 `/api` 反向代理。
5. 将后端字段从当前的 `title`、`status` 逐步改为更明确的 `name`、`direction`，并同步修改前端和数据库字段。

## 十、常见问题

### 1. 后端启动时报数据库连接错误

检查以下内容：

- MySQL 服务是否已启动
- `vue_task_db` 数据库是否存在
- `task` 表是否创建
- 用户名和密码是否正确
- MySQL 是否监听 `3306` 端口

### 2. Vue 执行 `npm run dev` 失败

先确认 Node.js 和 npm 版本，再删除并重新安装依赖：

```bash
cd my-vue-page
rm -rf node_modules package-lock.json
npm install
```

Windows PowerShell 可以使用：

```powershell
Remove-Item -Recurse -Force node_modules
Remove-Item -Force package-lock.json
npm.cmd install
```

如果错误信息指向 `axios`，请在 `my-vue-page` 目录执行 `npm install axios`。

### 3. Vue 刷新 `/edu` 或 `/todo` 后出现 404

这是 history 路由部署时缺少回退配置导致的。Nginx、Apache 或其他静态服务器需要将未知路径回退到 `index.html`，具体配置参考上文的 Nginx 示例。

### 4. HTML 页面图片或样式无法加载

检查 `test.html`、`style.css`、`test.js` 和图片文件是否仍处于同一目录，并确认文件名大小写完全一致。

### 5. 中文显示为乱码

部分历史文件可能曾经使用了不一致的字符编码。建议使用 VS Code 或 IntelliJ IDEA 将源码统一保存为 UTF-8，并检查 HTML 是否包含：

```html
<meta charset="UTF-8">
```

## 十一、项目定位与后续建议

当前项目更适合作为前后端学习和功能练习项目，而不是已经完成生产加固的正式系统。后续可以继续完善：

- 统一用户实体、接口和数据库字段命名
- 为后端增加参数校验、异常处理和更规范的 HTTP 状态码
- 使用环境变量管理数据库密码
- 为 Vue 页面补充 Axios 请求层和统一 API 配置
- 增加前端路由鉴权和表单校验
- 增加数据库初始化脚本和测试数据脚本
- 增加后端单元测试、接口测试和前端构建检查
- 清理 Vite 默认组件、无用资源和历史练习代码
- 统一所有源文件编码为 UTF-8

## 十二、快速启动摘要

启动后端：

```powershell
cd D:\HUODUAN\demo
.\mvnw.cmd spring-boot:run
```

启动 Vue 前端：

```powershell
cd D:\HUODUAN\my-vue-page
npm.cmd install
npm.cmd run dev
```

打开原生 HTML 页面：

```text
D:\HUODUAN\HTML\test.html
```
