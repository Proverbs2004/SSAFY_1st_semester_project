<template>
  <div>
    <h2 class="event-heading">운동 이벤트</h2>
    <table class="event-table">
      <thead>
        <tr>
          <th>이벤트 제목</th>
          <th>시작일</th>
          <th>종료일</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="event in events" :key="event.id" @click="showEventDetails(event)">
          <td>{{ event.title }}</td>
          <td>{{ event.startDate }}</td>
          <td>{{ event.endDate }}</td>
          <td>
            <button @click="registerForEvent(event)" class="register-btn">이벤트 등록</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="selectedEvent" class="event-details">
      <h3>{{ selectedEvent.title }}</h3>
      <p>{{ selectedEvent.description }}</p>
      <p>시작일: {{ selectedEvent.startDate }}</p>
      <p>종료일: {{ selectedEvent.endDate }}</p>
      <button @click="registerForEvent(selectedEvent)" class="register-btn">이벤트 등록</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      events: [
        {
          id: 1,
          title: '헬스 클럽 오픈 이벤트',
          description: '헬스 클럽 신규 오픈을 기념하여 특별 할인 혜택과 이벤트를 제공합니다.',
          startDate: '2023-06-01',
          endDate: '2023-06-15',
        },
        {
          id: 2,
          title: '스포츠 대회',
          description: '지역 스포츠 대회가 개최되며 참가자를 모집합니다.',
          startDate: '2023-07-10',
          endDate: '2023-07-15',
        },
        // 추가적인 이벤트 데이터를 여기에 추가할 수 있습니다.
      ],
      selectedEvent: null,
    };
  },
  methods: {
    showEventDetails(event) {
      this.selectedEvent = event;
    },
    registerForEvent(event) {
      // 이벤트 등록 로직을 작성하세요.
      console.log(`이벤트 등록 - ${event.title}`);
    },
  },
}
</script>


<style scoped>
.event-heading {
  text-align: center;
  color: #f44336;
  margin-bottom: 20px;
}

.event-table {
  width: 100%;
  border-collapse: collapse;
}

.event-table th,
.event-table td {
  padding: 10px;
  border-bottom: 1px solid #ccc;
  text-align: center;
}

.register-btn {
  padding: 8px 16px;
  background-color: #f44336;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.register-btn:hover {
  background-color: #d32f2f;
}

.event-details {
  margin-top: 20px;
  text-align: center;
}
</style>
