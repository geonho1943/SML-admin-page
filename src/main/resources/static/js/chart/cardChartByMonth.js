document.addEventListener('DOMContentLoaded', function () {
    // axios 요청들을 병렬로 처리하여 모든 데이터를 가져옴
    axios.all([
        axios.get('http://localhost:8080/api/chart/cards/check-count/month'),
        axios.get('http://localhost:8080/api/chart/cards/create-count/month'),
        axios.get('http://localhost:8080/api/chart/cards/delete-count/month'),
        axios.get('http://localhost:8080/api/chart/cards/deactivate-count/month')
    ])
    .then(axios.spread((checkResponse, createResponse, deleteResponse, deactivateResponse) => {
        // 각 API에서 받은 데이터를 변수에 저장
        const checkData = checkResponse.data;
        const createData = createResponse.data;
        const deleteData = deleteResponse.data;
        const deactivateData = deactivateResponse.data;

        // 데이터를 시간 순서대로 정렬
        checkData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        createData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        deleteData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        deactivateData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));

        // 각 데이터에서 labels와 counts를 추출
        const labels = checkData.map(item => item.chartTime); // x축 라벨은 checkData 기준으로 설정
        const checkCounts = checkData.map(item => item.activeCount);
        const createCounts = createData.map(item => item.activeCount);
        const deleteCounts = deleteData.map(item => item.activeCount);
        const deactivateCounts = deactivateData.map(item => item.activeCount);

        // Chart.js 구성
        const ctx = document.getElementById('cardChartByMonth').getContext('2d');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [
                    {
                        label: 'Create',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        data: checkCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Check',
                        backgroundColor: 'rgba(192, 75, 192, 0.2)',
                        borderColor: 'rgba(192, 75, 192, 1)',
                        data: createCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Delete',
                        backgroundColor: 'rgba(192, 192, 75, 0.2)',
                        borderColor: 'rgba(192, 192, 75, 1)',
                        data: deleteCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Deactivate',
                        backgroundColor: 'rgba(75, 75, 192, 0.2)',
                        borderColor: 'rgba(75, 75, 192, 1)',
                        data: deactivateCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    }
                ]
            },
            options: {
                scales: {
                    x: {
                        type: 'time',
                        time: {
                            parser: 'YYYY-MM-DDTHH:mm:ss',
                            unit: 'hour',
                            tooltipFormat: 'YYYY-MM-DDTHH:mm',
                            displayFormats: {
                                hour: 'MM:DD'
                            }
                        },
                        title: {
                            display: true,
                            text: 'Month'
                        },
                        ticks: {
                            source: 'data',
                            autoSkip: false
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'Card'
                        },
                        beginAtZero: true
                    }
                }
            }
        });
    }))
    .catch(error => console.error('Error fetching the data:', error));
});