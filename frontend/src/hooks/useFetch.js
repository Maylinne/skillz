import { useEffect, useState } from "react";

export function useFetch(fetchFn, fetchArgs, initialValue) {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const [fetchedData, setFetchedData] = useState(initialValue);

  useEffect(() => {
    async function fetchData() {
      setIsLoading(true);
      try {
        const data = await fetchFn(fetchArgs);
        // console.log("Fetched data:", data);
        setFetchedData(data);
      } catch (error) {
        setError({ message: error.message || 'Failed to fetch data.' });
        console.log("Error message: " + error.message);
      }
      setIsLoading(false);
    }

    fetchData();
  }, [fetchFn, fetchArgs]);

  return {
    isLoading,
    error,
    fetchedData,
    setFetchedData,
  };
}
