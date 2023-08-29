<!-- <template>
    <div>
      <div>
        <h3>유저 상세</h3>
        <div>아이디 : {{ user.userId }}</div>
        <div>비밀번호 : {{ user.userPwd }}</div>
        <div>이름 : {{ user.userName }}</div> 
        <div>닉네임 : {{ user.userNickname }}</div>
        <button @click="moveUpdate">수정</button>
        <button @click="deleteArticle">삭제</button>
      </div>

    </div>
  </template> -->


  <template>
    <div>
      <h3>유저 상세</h3>
      
      <table>
        <tr>
          <td>아이디</td>
          <td>{{ user.userId }}</td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>{{ user.userPwd }}</td>
        </tr>
        <tr>
          <td>이름</td>
          <td>{{ user.userName }}</td>
        </tr>
        <tr>
          <td>닉네임</td>
          <td>{{ user.userNickname }}</td>
        </tr>
      </table>
      <button @click="moveUpdate">수정</button>
      <button @click="deleteArticle">삭제</button>
    </div>
  </template>
  
  <script>
  import { mapState } from "vuex";

  export default {
    name: "UserDetail",
    computed: {
      ...mapState(["user"]),
    },
    created() {
      const pathName = new URL(document.location).pathname.split("/");
      const id = pathName[pathName.length-1];
      console.log(id);
      this.$store.dispatch("getUser", String(id));
    },
    methods: {
      moveUpdate() {
        this.$router.push({ name: "userUpdate" });
      },
      deleteArticle() {
        if(confirm("정말로 삭제하시겠습니까?")){
          // console.log(this.article.articleSeq);
          this.$store.dispatch("deleteUser", this.user.userId);
        }
      },
    },
  };
  </script>
  
  <style></style>